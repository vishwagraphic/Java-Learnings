	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		
		<h3>Enter new todo Details</h3>
		<form:form method="post" modelAttribute="todo">
		<form:input type="hidden" name="id" path="id"  />
		
		<form:input type="hidden" name="done" path="done"  />
		<fieldset class="mb-3">
			<form:label path="description">Description:</form:label>
			<form:input type="text" name="description" path="description" />
			<form:errors cssClass="text-warning" path="description" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" name="targetDate" path="targetDate" />
			<form:errors cssClass="text-warning" path="targetDate" />
		</fieldset>
		<input type="submit" class="btn btn-success" />
		</form:form>
		</div>
		<%@ include file="common/footer.jspf" %>
		<script type="text/javascript">
			$('#targetDate').datepicker({
				format: "yyyy-mm-dd"
			})
		</script>