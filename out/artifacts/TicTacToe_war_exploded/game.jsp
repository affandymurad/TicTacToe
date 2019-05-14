<%--
  Created by IntelliJ IDEA.
  User: affandymurad
  Date: 12/05/19
  Time: 22.57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="morpionBean" scope="session" class="tic.tac.toe.Morpion" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tic Tac Toe</title>
</head>
<body>
<h1>Tic Tac Toe</h1>
<table border="1">
    <c:forEach var="line" items="${morpionBean.garisUbin}">
        <tr>
            <c:forEach var="cell" items="${morpionBean.getStatusUbin(line)}">
                <td>
                    <c:choose>
                        <c:when test="${cell.state == 'X'}">
                            <img src="img/state_x.png" alt="X"/>
                        </c:when>
                        <c:when test="${cell.state == 'O'}">
                            <img src="img/state_o.png" alt="O"/>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${winner == null}">
                                <a href="morpionServlet?Garis=${cell.line}&Kolom=${cell.col}">
                            </c:if>
                            <img src="img/state_null.png" alt="null"/>
                            <c:if test="${winner == null}">
                                </a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<c:if test="${winner != null}">
<h1>${winner} Menang !</h1>
    <form action="index.jsp" method="post">
        <input type="submit" name="Replay" value="Ulangi..."><br/>
    </form>
    </c:if>
</body>
</html>
