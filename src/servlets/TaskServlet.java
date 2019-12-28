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
import java.util.ArrayList;

@WebServlet(name = "TaskServlet", value = "/tasks")
public class TaskServlet extends HttpServlet {
    private DBManager manager;

    public void init(){
        manager = new DBManager();
        manager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("user_session");

        if(user != null){
            ArrayList<Tasks> tasks = manager.getOwnTasks(user.getId());
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("tasks.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        }
    }
}
