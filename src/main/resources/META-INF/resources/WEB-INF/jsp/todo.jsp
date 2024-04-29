<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
	
	<title>Add Todo Page</title>
</head>
<body>
<div class="container">
	
	<h3>Enter Todo Details</h3>
	
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required"/>
			<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3" >
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="date" path="targetDate" required="required" id="targetDate" />
			<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<input type="submit" class="btn btn-primary"/>
	
	</form:form>


</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>



</body>
</html>