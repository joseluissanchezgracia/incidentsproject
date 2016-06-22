<%--Vista JSP para mostrar detalle de incidente y modificar descripcion --%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title><fmt:message key="incidents.show.title" /></title>
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
				<fmt:message key="incidents.show.title" />
			</h1>

			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.id" />
					</div>
					<div class="col-sm-9">${incident.id}</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.priority" />
					</div>
					<div class="col-sm-9">${incident.priority}</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.state" />
					</div>
					<div class="col-sm-9"><fmt:message key="label.Incident.state${incident.state}" /></div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.creationDate" />
					</div>
					<div class="col-sm-9">
						<fmt:formatDate type="both" value="${incident.creationDate}" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.operator" />
					</div>
					<div class="col-sm-9">${incident.operator}</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.address" />
					</div>
					<div class="col-sm-9">${incident.address}</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.incidentType" />
					</div>
					<div class="col-sm-9">${incident.type.typeName}</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<fmt:message key="label.Incident.description" />
					</div>
					<div class="col-sm-9">
						<spring:url value="save" var="saveUrl">
						</spring:url>
						<form:form modelAttribute="incident" action="${saveUrl}"
							method="POST" role="form" class="form-horizontal">
							<form:hidden path="id" />
							<fieldset>
								<div class="form-group">

									<div class="col-sm-10">
										<form:textarea path="descripcion" class="form-control"
											rows="6" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-10">
										<button id="saveButton" type="submit"
											class="btn button-default">
											<fmt:message key="command.save" />
										</button>
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>

			</div>


			<div>
				<h2>
					<fmt:message key="label.Incident.operations" />
				</h2>
				<c:if test="${!empty incident.operations}">
					<table class="table table-striped">
						<thead>
							<tr>
								<th><fmt:message key="label.Incident.operations.operation" />
								</th>
								<th><fmt:message key="label.Incident.operations.operator" /></th>
								<th><fmt:message key="label.Incident.operations.date" />
								</th>
								<th><fmt:message key="label.Incident.operations.parameters" />
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="operation" items="${incident.operations}">
								<tr>
									<td>${operation.operationId}</td>
									<td>${operation.operator}</td>
									<td><fmt:formatDate type="both" value="${operation.date}" /></td>
									<td>${operation.parameters}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<c:if test="${empty incident.operations}">
					<fmt:message key="incidents.show.label.noOperations" />
				</c:if>
			</div>

		</div>

		<div class="row">
			<p>
				<fmt:message key="footer.message" />
			</p>
		</div>

	</div>
</body>
</html>