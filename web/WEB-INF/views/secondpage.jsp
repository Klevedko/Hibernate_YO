<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<p><a href="http://localhost:8080/"><img src="<c:url value='/resources/images/logotype.jpg'/>" alt="welcome"/></a></p>

<body>
Введенное имя: ${userJSP.name};
<br/>
Введенный пароль: ${userJSP.password};

<br/>
</body>
</html>
