package servlets;

import db.DBManager;
import db.Tasks;
import db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReadServlet", value = "/read")
public class ReadServlet extends HttpServlet {
    private DBManager manager;

    public void init(){
        manager = new DBManager();
        manager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Tasks task = manager.getTaskById(id);
        Users user = (Users) request.getSession().getAttribute("user_session");
        if(user != null) {
            if(task != null){
                request.setAttribute("read", task);

                request.getRequestDispatcher("main.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("tasks").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("/").forward(request,response);
        }
    }
}
