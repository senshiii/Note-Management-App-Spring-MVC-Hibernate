<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="updateLink" value="/notes/update">
	<c:param name="noteId" value="${param.id}" />
</c:url>

<c:url var="deleteLink" value="/notes/delete">
	<c:param name="noteId" value="${param.id}" />
</c:url>

<div class="col">
	<div class="card border-dark h-100">
		<div class="card-header">
			<small class="m-0 d-inline-block w-100">Created At: <strong>${param.origin}</strong></small>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				<c:out value="${param.title}" />
			</h5>
			<hr>
			<p class="card-text">
				<c:out value="${param.content}" />
			</p>
		</div>
		<div
			class="card-footer d-flex flex-column flex-md-row justify-content-between align-items-center">
			<div
				class="w-100 ml-auto d-flex justify-content-center align-items-center flex-column flex-md-row">
				<a href="${updateLink}"
					class="mx-2 w-100 my-1 btn btn-block btn-outline-primary">Edit</a>
				<a href="${deleteLink}"
					class="mx-2 w-100 my-1 btn btn-block btn-outline-danger">Delete</a>
			</div>
		</div>
	</div>
</div>
