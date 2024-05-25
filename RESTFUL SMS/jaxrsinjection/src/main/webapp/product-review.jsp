<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product Review</title>
	</head>
	<body>
		<h2>Product Review</h2>
		<form action="rest/review" method="post">
			Reviewer Name: <input type="text" name="reviewerName"/> <br/>
			Product code: <input type="text" name="productCode"/><br/>
			Rating: <input type="number" name="rating"/><br/>
			Comments: <textarea rows="3" cols="15" name="comments"></textarea><br/>
			<input type="submit" value="review"/>
		</form>
	</body>
</html>