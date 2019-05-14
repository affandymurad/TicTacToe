<%--
  Created by IntelliJ IDEA.
  User: affandymurad
  Date: 13/05/19
  Time: 17.39
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
    <c:forEach var="garis" items="${morpionBean.garisUbin}">
        <tr>
            <c:forEach var="sel" items="${morpionBean.getStatusUbin(garis)}">
                <td>
                    <c:choose>
                        <c:when test="${sel.keadaan == 'X'}">
                            <img src="gambar/keadaan_x.png" alt="X"/>
                        </c:when>
                        <c:when test="${sel.keadaan == 'O'}">
                            <img src="gambar/keadaan_o.png" alt="O"/>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${pemenang == null}">
                                <a href="morpionServlet?Garis=${sel.garis}&Kolom=${sel.kolom}">
                            </c:if>
                            <img src="gambar/keadaan_hampa.png" alt="null"/>
                            <c:if test="${pemenang == null}">
                                </a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<c:if test="${pemenang != null}">
    <h1>${pemenang} Menang !</h1>
    <form action="index.jsp" method="post">
        <input type="submit" name="Ulang" value="Ulangi..."><br/>
    </form>
</c:if>
</body>
</html>
