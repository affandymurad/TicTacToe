<%--
  Created by IntelliJ IDEA.
  User: affandymurad
  Date: 13/05/19
  Time: 11.12
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="morpionBean" scope="session" class="tic.tac.toe.Morpion" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Tic Tac Toe - Affandy Murad</title>
</head>
<body>
<h1>Tic Tac Toe</h1>
<form action="awalServlet" method="post">
  <h1>Jumlah ubin:  <input type = "number" min="2" step="1" name = "Ubin" required="required" style="font-size : 20px; width: 60px; height: 30px;"> </h1>
  <br />
  <input type="submit" name="Pemain" value="Saya mulai..." style="font-size : 20px; width: 150px; height: 50px;"><br/><br/>
  <input type="submit" name="Komputer" value="Komputer mulai..." style="font-size : 20px; width: 200px; height: 50px;">
</form>

<script type="text/javascript">
    function validateForm()
    {
        var x=document.forms["Ubin"].value;
        if (x==null || x.isEmpty())
        {
            alert("Please Fill Grid Size Field");
            return false;
        }
    }
</script>
</body>
</html>
