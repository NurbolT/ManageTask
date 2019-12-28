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

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    private DBManager manager;

    public void init(){
        manager = new DBManager();
        manager.connect();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Long id = Long.parseLong(request.getParameter("id"));
        Date date = new Date();
        Users user = (Users) request.getSession().getAttribute("user_session");

        if(user != null){
            Tasks task = new Tasks(id, user.getId(), title, description, date);
            manager.editTask(task);
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Tasks task = manager.getTaskById(id);
        Users user = (Users) request.getSession().getAttribute("user_session");
        if(user != null) {
            if(task != null){
                request.setAttribute("task", task);
                request.getRequestDispatcher("addtask").forward(request, response);
            }else {
                request.getRequestDispatcher("addtask").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("/").forward(request,response);
        }
    }
}
