<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<p><a href="http://localhost:8080/login"><img src="<c:url value='/resources/images/logotype.jpg'/>" alt="welcome"/></a></p>

<body>
ERROR! Пользователь не найден! Compete it!
<br/>

<select>
    <cc:forEach items="${allContacts}" var="contactList">
        <option>${contactList.id}</option>
    </cc:forEach>
</select>

<table>
    <tr>
        <th>Доступные ID для входа</th>
        <!--<th>ISBN2</th>-->
    </tr>
    <cc:forEach items="${allContacts}" var="contactList">
        <tr>
            <td>
                <cc:out value="${contactList.id}"/>
            </td>
                <%--%><td>
                    <cc:out value="${contactList.password}"/>
                </td>--%>
        </tr>
    </cc:forEach>
</table>

</body>
</html>
