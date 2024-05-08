<%@page import="Bank.Model.Recharge"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RechargeHistoryController">
<h2> Recharge History</h2>
<input type="submit" value="History_of_recharge">
</form>



<%!List<Recharge> lst; %>
<%if(!session.isNew()){
try{
	response.setHeader("Refresh", "2");
lst=(List<Recharge>)session.getAttribute("Rechargelst"); 
for(Recharge r:lst)
{
	%>
<table border="2px">
<h3>Recharge History</h3>

<tr>
<td>SrNo</td>
<td>Phone Number</td>
<td>Service Provider</td>
<td>Ammount</td>
<td>date</td>
<td>Balance</td>
</tr>

<tr>
<td><%=r.getIndex() %></td>
<td><%=r.getPhNo() %></td>
<td><%=r.getCard() %></td>
<td><%=r.getAmont() %></td>
<td><%=r.getDate() %></td>
<td><%=r.getBalance() %></td>

</tr>
</table>

<% 
}
}catch(Exception e){
	e.printStackTrace();
}
} 
%>
</body>
</html>