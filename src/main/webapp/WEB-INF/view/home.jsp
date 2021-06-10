<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home Page</title>
<%@ include file="templates/base_head_links.jsp" %>

</head>
<body>
	<%@ include file="templates/header.jsp" %>
	
	<div class="container-fluid mt-5 pb-5">
		<div class="row mx-auto">
			<div class="col-11 col-md-9 mx-auto">
				<div class="d-flex justify-content-between align-items-center">
					<h3>Your Notes</h3>
					<a href="notes/new" class="btn btn-outline-success" >New Note</a>
				</div>
				<hr>
			</div>
			<div class="col-11 col-md-9 mx-auto mt-2">
				<div class="row row-cols-1 row-cols-md-2 g-4">
					<c:forEach items="${notes}" var="noteObj">
						<jsp:include page="notes/note-card.jsp">
							<jsp:param name="title" value="${noteObj.title}"/>
							<jsp:param name="content" value="${noteObj.content}"/>
							<jsp:param name="id" value="${noteObj.id}" />
							<jsp:param name="origin" value="${noteObj.origin.toLocaleString()}" />
						</jsp:include>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>