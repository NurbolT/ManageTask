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
import java.util.Date;

@WebServlet(name = "AddtaskServlet", value = "/addtask")
public class AddtaskServlet extends HttpServlet {
    private DBManager manager;

    public void init(){
        manager = new DBManager();
        manager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Date date = new Date();
        Users user = (Users) request.getSession().getAttribute("user_session");

        if(user != null){
            Tasks task = new Tasks(null, user.getId(), title, description, date);
            manager.addTask(task);
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("user_session");

        if(user != null){
            request.getRequestDispatcher("addtask.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        }
    }
}
