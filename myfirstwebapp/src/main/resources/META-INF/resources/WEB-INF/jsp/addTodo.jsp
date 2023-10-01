<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <form:form method="post" modelAttribute="todo">
        <fieldset>
            <form:label path="description">Description</form:label>
            <form:input type="text" name="description" required="required" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
<%--        <fieldset>--%>
<%--            <form:input type="hidden" name="done" path="done"/>--%>
<%--        </fieldset>--%>
<%--        <fieldset>--%>
<%--            <form:input type="hidden" name="id"  path="id"/>--%>
<%--        </fieldset>--%>
<%--        <fieldset>--%>
<%--            <form:input type="hidden" name="username"  path="username"/>--%>
<%--        </fieldset>--%>
        <fieldset>
            <form:label path="date">Target Date</form:label>
            <form:input type="text" name="date" required="required" path="date"/>
            <form:errors path="date" cssClass="text-warning"/>
        </fieldset>
        <br>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#date').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
