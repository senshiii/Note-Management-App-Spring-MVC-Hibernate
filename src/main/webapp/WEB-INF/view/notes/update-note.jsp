<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Note</title>
<%@ include file="../templates/base_head_links.jsp" %>
</head>
<body>
	<%@ include file="../templates/header.jsp" %>
	
	<div class="row mx-auto mt-5">
		<div class="col-9 mx-auto">
			<h3 class="mb-2" >Update Note</h3>
			<hr>
			<form:form modelAttribute="note" cssClass="mt-2" action="" method="POST" >
				<div class="mb-3">
					<form:label path="title">Title</form:label>
					<form:input path="title" cssClass="form-control" autocomplete="false"  />
				</div>
				<div class="mb-3">
					<form:label path="content">Content</form:label>
					<form:textarea 
						maxlength="350" 
						cssStyle="height:140px;max-height:140px;min-height:140px;" 
						path="content" 
						cssClass="form-control" 
						autocomplete="false"  />
					<div class="form-text">Max 350 characters allowed</div>
				</div>
				<form:hidden path="id"/>
				<input type="submit" value="Update Note" class="btn btn-success d-inline" />
				<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger d-inline ml-5">Cancel</a>
			</form:form>
		</div>
	</div>
	
</body>
</html>