<%--Vista JSP para pantalla de bienvenida --%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="<c:url value="/resources/styles/bootstrap/3.3.5/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/styles/bootstrap/3.3.5/css/bootstrap-theme.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/styles/incidents.css" />" />

<title><fmt:message key="welcome.title" /></title>
</head>
<body>

	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div>
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/admin/incidents/"/>"><fmt:message
									key="navigate.incidents" /></a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>

		<div class="row">
			<h1>
				<fmt:message key="welcome.title" />
			</h1>

			<cite> <fmt:message key="welcome.caption" />
			</cite>
		</div>

		<div class="row">
			<p>
				<fmt:message key="footer.message" />
			</p>
		</div>
	</div>

</body>
</html>