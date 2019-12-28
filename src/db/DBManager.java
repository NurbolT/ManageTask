package db;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private Connection connection;

    public DBManager(){

    }

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_task?useUnicode=true&serverTimezone=UTC","root","");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerUser(Users user){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, login, password, fullname) VALUES (NULL, ?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Users getUserByLoginAndPassword(String login, String password){
        Users users = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login='"+login+"' AND password='"+password+"'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users = new Users(resultSet.getLong("id"),resultSet.getString("login"),resultSet.getString("password"),resultSet.getString("fullname"));
            }


            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }


    public void addTask(Tasks task){
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO tasks (id, userId, title, description, addedDate) VALUES (NULL, ?, ?, ?, ?)");
            statement.setLong(1, task.getUserId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setDate(4,  new java.sql.Date(task.getAddedDate().getTime()));

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Tasks> getOwnTasks(Long id){
        ArrayList<Tasks> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE userId='"+id+"'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                tasks.add(new Tasks(resultSet.getLong("id"),resultSet.getLong("userId"),resultSet.getString("title"),resultSet.getString("description"), resultSet.getDate("addedDate")));
            }


            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return tasks;
    }

    public Tasks getTaskById(Long id){
        Tasks task = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE id='"+id+"'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                task = new Tasks(resultSet.getLong("id"), resultSet.getLong("userId"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getDate("addedDate"));

            }


            resultSet.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return task;
    }


    public void editTask(Tasks task){
        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE tasks set userId = ?, title = ?, description = ?, addedDate = ? WHERE id = '"+task.getId()+"'");
            statement.setLong(1, task.getUserId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setDate(4,  new java.sql.Date(task.getAddedDate().getTime()));

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteTask(Long id){
        try {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM tasks WHERE id = '"+id+"'");


            statement.execute();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
