<%@ page import="db.Tasks" %>
<%@ page import="db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users user = (Users) request.getSession().getAttribute("user_session");
%>
<html>
<head>
    <title>Add task</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
    <%@include file="menu.jsp"%>




    <%
        Tasks task = (Tasks) request.getAttribute("task");
        if(task == null){
    %>
    <div class="container mt-3">
        <div class="row">
            <div class="col-6">
                <form action="addtask" method="post">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Title</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="title">
                    </div>


                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>

            </div>
        </div>
    </div>

    <%
    }else {
    %>

    <div class="container mt-3">
        <div class="row">
            <div class="col-6">
                <form action="edit" method="post">
                    <div class="form-group">
                        <label for="exampleFormControlInput2">Title</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" name="title" value="<%=task.getTitle()%>">
                    </div>


                    <div class="form-group">
                        <label for="exampleFormControlTextarea2">Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea2" rows="3" name="description"><%=task.getDescription()%></textarea>
                    </div>
                    <input type="hidden" name="id" value="<%=task.getId()%>">
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
                <a href="/">Go back</a>
            </div>
        </div>
    </div>
    <%}%>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
