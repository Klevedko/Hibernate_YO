<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<p><a href="http://localhost:8080/"><img src="<c:url value='/resources/images/logotype2.jpg'/>" alt="welcome"/></a></p>

<body>
ERROR
<br/>
Пользователь не найден!
Compete it!
<br/>

<select>
    <cc:forEach items="${contactList}" var="contactList">
        <option>${contactList.id}</option>
    </cc:forEach>
</select>

<table>
    <tr>
        <th>ISBN</th>
        <th>ISBN2</th>
    </tr>
    <cc:forEach items="${contactList}" var="contactList">
        <tr>
            <td>
                <cc:out value="${contactList.id}"/>
            </td>
            <td>
                <cc:out value="${contactList.surname}"/>
            </td>
        </tr>
    </cc:forEach>
</table>

</body>
</html>
