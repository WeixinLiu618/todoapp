<html>
<head>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
	<title>Welcome Page</title>
</head>
<body>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<h1>Welcome ${name}</h1>
	
	<a href="list-todos">Manage</a> your todos.
</div>
<%@include file="common/footer.jspf"%>
