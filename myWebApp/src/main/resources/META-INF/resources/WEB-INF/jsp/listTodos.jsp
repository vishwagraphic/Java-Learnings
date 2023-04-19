	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		
		<h3>${name}, Here is Your Todo List</h3>
		<table class="table">
			<thead>
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done</th>
				<th>Want to Delete</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
			<%@ include file="common/footer.jspf" %>