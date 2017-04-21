<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kysymyksen luonti</title>
<link rel="stylesheet" type="text/css" href="resources/styles/common.css">
</head>
<body>
	<h1>Luo Uusi Kysymys</h1>
	<br/>
	<form:form modelAttribute="kysymys" method="post">
	<fieldset>
		<p>
			<form:label path="kysymys">Kysymys</form:label><br/>
			<form:input path="kysymys" />
			<br/>
			<br/>	
		</p>
		<p>
			<form:label path="tyyppi">Minka tyyppinen kysymys (monivalinta, kylla/ei)?</form:label><br/>
			<form:input path="tyyppi"/>
			<br/>
			<br/>
		</p>
		<br/>	
			<a href="kys/kiitos">Kiitos</a>
		</fieldset>
	</form:form>
    
</body>
</html>