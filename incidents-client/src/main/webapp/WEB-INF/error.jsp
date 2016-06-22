<%--Vista JSP para mostrar error generico --%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<title><fmt:message key="incidents.list.title" /></title>
</head>
<body>

	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div>
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/admin/home"/>"><fmt:message
									key="navigate.home" /></a></li>
						<li><a href="<c:url value="/admin/incidents/"/>"><fmt:message
									key="navigate.incidents" /></a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>

		<div class="row">
			<h1>
				<fmt:message key="error.title" />
			</h1>

			<cite> <fmt:message key="error.message" />
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