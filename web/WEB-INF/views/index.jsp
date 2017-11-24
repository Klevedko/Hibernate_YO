<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>123</title>
    <script>
        function isCorrect() {
            if (1 ==1) {
                return "sdsdsadas"
            }
        }
    </script>
</head>

<body>
<spring:form method="post" modelAttribute="userJSP" action="check-user">
    Name: <spring:input path="name" /> <br/>
    Password: <spring:input path="password"/> <br/>
    <input type='submit' name='submit' value='submit'/>
    <input type='reset' name='cancel' value='cancel'/>
    label: <spring:input path="label" /> <br/>
    <textarea id="my-text-box" name="asdasd" rows="1" cols="50">HERE WE GO </textarea>
</spring:form>

</body>
</html>
