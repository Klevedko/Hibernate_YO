<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<p><a href="http://localhost:8080/"><img src="<c:url value='/resources/images/logotype.jpg'/>" alt="welcome"/></a></p>

<body>
ERROR
<br/>
you have entered:
<br/>
name = ${userJSP.name};
<br/>
pas = ${userJSP.password};
<br/>
Compete it!
<br/>

</body>
</html>
