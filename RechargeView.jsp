<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recharge Here</title>
</head>
<body>
	<form action="RechargeController">
		<table>


			<label class="form-label" for="form3Example3cg">Contact
				Number</label>
			<input type="number" name="contactNo">
			<br>

			<label class="form-label" for="form3Example3cg">Service
				Provider</label>
			<select name="card" id="card">
				<option value="JIO">JIO</option>
				<option value="VI">VI</option>
				<option value="AIRTEL">AIRTEL</option>
				<option value="BSNL">BSNL</option>
			</select>
			<br>



			<!-- <label class="form-label" for="form3Example3cg">Ammount</label>
			<input type="number" name="amt"><br>
			 -->

			<label class="form-label" for="form3Example3cg">Amount</label>
			<select name="amt" id="amt">
				<option value="199">199</option>
				<option value="250">250</option>
				<option value="550">550</option>
				<option value="1650">1650</option>
			</select><br>

			<input type="submit" value="Recharge">
		</table>

	</form>

</body>
</html>