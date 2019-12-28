<%@ page import="java.util.ArrayList" %>
<%@ page import="db.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

    <%

            Tasks read = (Tasks) request.getAttribute("read");
            if(read != null){
            out.print(read.getDescription());
        }else{
    %>
    Tasks : <br>

    <div class="container">
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Date</th>
                    </tr>
                    </thead>
                    <%
                        ArrayList<Tasks> tasks = (ArrayList<Tasks>) request.getAttribute("tasks");
                        if(tasks != null) {
                            for (Tasks t : tasks) {
                    %>
                    <tbody>
                    <tr>
                        <th scope="row"><%=t.getId()%></th>
                        <td><%=t.getTitle()%></td>
                        <td><%=t.getAddedDate()%></td>
                        <td><a href="edit?id=<%=t.getId()%>">Edit</a></td>
                        <td><a href="delete?id=<%=t.getId()%>">Delete</a></td>
                        <td><a href="read?id=<%=t.getId()%>">Read</a></td>
                    </tr>
                    </tbody>
                    <%
                            }
                        }
                    %>
                </table>
            </div>
        </div>
    </div>






    <a href="addtask">Add task</a>

    <%
        }
    %>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
