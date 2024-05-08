<%@page import="Bank.Model.Registor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.navbar{
background-color:silver;
display:flex;
justify-content:right;
align-items:center;
height:80px;
opacity: 100px;

}

.navbar a{
display: block;
padding: 15px 30px;
margin: 0 20px;
background-color: #fff;
color:#333;
border-radius:8px;
box-shadow: 0 4px 8px rgba(0,0,0,0.1);
transition:transform 0.2s,box-shadow 0.2s;
font-weight: bold;
font-size: 18px;
}

button {
	display: block;
padding: 15px 25px;
margin: 0 20px;
background-color: #fff;
color:#333;
border-radius:8px;
box-shadow: 0 4px 8px rgba(0,0,0,0.1);
transition:transform 0.1s,box-shadow 0.1s;
font-weight: bold;
font-size: 16px;
}
body{
background-color: lime;
background-image: url("https://img.freepik.com/premium-vector/financial-banking-technology-concept_387612-31.jpg");
background-size: cover;
}

</style>

</head>
<body>
<div class="navbar">
	<table>
		<a href="ShowRecords">MyRecord</a><br>
		<!-- <a href="BankHome.jsp">Home</a><br> -->
			<a href="RechargeView.jsp">Recharge</a><br>
			
		
			<form action="RechargeHistoryView.jsp" method="post">
				<button>Rechange History</button><br>
			</form>
			
			
			<form action="NetBankingNFT.jsp" method="post">
				<button>NetBanking</button><br>
			</form>
			
		<form action="AddAmount.jsp" method="post">
				<button>ADD MONEY</button><br>
			</form>
			
			<a href="LogoutServletContro">Logout</a><br>
			
			
			
		
	
	

	</table>
		</div>

<h1>WELCOME BRO</h1>
<!-- <a href="DashBoard.jsp">Home</a> -->



<%!List<Registor> lst; %>
<% if(!session.isNew()){
	try{
	lst=(List<Registor>)session.getAttribute("Custlst");
	Registor r=lst.get(0);
	%>
	<table border="2px">
	<tr>
	<td>Accno</td>
	<td>Name</td>
	<td>Pan No</td>
	<td>Adhar</td>
	<td>Branch</td>
	<td>Email</td>
	<td>UserName</td>
	<td>Password</td>
	<td>Update</td>
	<td>Delete</td>
	</tr>
	
	<tr>
	<td><%=r.getAc_no() %></td>
	<td><%=r.getCust_name() %></td>
	<td><%=r.getPan_no() %></td>
	<td><%=r.getAdhar_no() %></td>
	<td><%=r.getBank_branch() %></td>
	<td><%=r.getMail() %></td>
	<td><%=r.getUser_name() %></td>
	<td><%=r.getPassword() %></td>
	<td><a href="UpdateUserInfoController"><button>Update</button> </a> </td>
	<td><a href="DeleteView.jsp"><button>Delete</button> </a> </td>
	</tr>
	</table>
	
	<% 
	}catch(Exception e){}
}
	%>


</body>
</html>