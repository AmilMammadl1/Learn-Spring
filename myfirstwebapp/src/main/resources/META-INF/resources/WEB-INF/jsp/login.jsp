<%@include file="common/header.jspf"%>
<div class="container">
    <h1>This is a login page </h1>
    ${err}
    <form method="post">
        Name: <input type="text" name="username">
        <br>
        Password <input type="password" name="password">
        <input type="submit">
    </form>
</div>
<%@include file="common/footer.jspf"%>
