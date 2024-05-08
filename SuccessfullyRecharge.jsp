<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recharge Succefully</title>
</head>
<body>


<%if(!session.isNew()){
String n=(String) session.getAttribute("nom");
double p=(double)session.getAttribute("amt");
%>
<h3><%=n %> Recharge Done Succefully......</h3>
<h3>for <%=p %> Rs...With Unlited Call + per day 1 GB data Validate 28 Days</h3>
<a href="DashBoard.jsp"><button>DashBoard</button>></a>
<%} %>
</body>
</html>