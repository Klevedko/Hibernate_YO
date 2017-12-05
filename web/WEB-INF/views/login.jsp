<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>123</title>
    <script>
        function isCorrect() {
            if (1 == 1) {
                alert('fdds');
            }
        }
    </script>
</head>
<body>
<p><a href="http://localhost:8080/login"><img src="<cc:url value='/resources/images/logotype.jpg'/>" alt="welcome" onclick="isCorrect()"/></a></p>
<div class="container">
    <div style="margin-left: 50%;">
        <h2>Нихьт няхьт</h2>
    </div>

    <div style="margin-bottom: 20px;">
        <h4><i class="icomoon-stack"></i>ЛЯ</h4>
        <hr style="margin-bottom: 10px; margin-top: 5px;">
        <div style="margin-left: 25px;">
            <p>
                <a href="/resources/mi.jsp" style="font-size: 22px; font-style: italic">Трынь-перетрынь </a>
            </p>
        </div>
        </hr>
    </div>

    <spring:form method="post" modelAttribute="userJSP" action="check-user">
    LoginId:
        <spring:input path="id" maxlength="7"  /> <br/>
    Password:
        <spring:input path="password" /> <br/>
    <input type='submit' name='submit' value='submit'/>
    <input type='reset' name='cancel' value='cancel'/>
    <input type='Button' name='testAction' value='test'  onclick="isCorrect()"/>
    <textarea id="my-text-box" name="asdasd" rows="1" cols="50">HERE WE GO </textarea>
    </spring:form>
</body>
</html>