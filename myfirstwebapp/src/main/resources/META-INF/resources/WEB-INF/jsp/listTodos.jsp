<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <div>Welcome ${username}</div>
    <hr>
    <h1>Your Todos</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>description</th>
            <th>Target Date</th>
            <th>IsDone</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listForOneUser}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.username}</td>
                <td>${todo.description}</td>
                <td>${todo.date}</td>
                <td>${todo.done}</td>
                <td style="width: 60px"><a href="/deletetodos?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                <td style="width: 60px"><a href="/updatetodos?id=${todo.id}" class="btn btn-warning">Update</a></td>


            </tr>
        </c:forEach>
        <a href="addtodo" class="btn btn-success">Add Todo</a>
        </tbody>
    </table>
</div>
<%@include file="common/footer.jspf"%>
