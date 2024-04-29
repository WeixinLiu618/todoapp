<html>
<head>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
	<title>Login</title>
</head>
<body>
<div class="container">
	<h1>Login</h1>
	<pre>${errorMessage}</pre>
	<form method="post">
		Name: <input type="text" name="name">
		Password: <input type="password" name="password">
		<input type="submit"/>
	</form>
</div>
<%@ include file="common/footer.jspf" %>