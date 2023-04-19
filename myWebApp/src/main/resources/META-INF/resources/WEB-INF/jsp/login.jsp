	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<div>${errorMessage}</div>
		<h1>Welcome to Login page</h1>
		<form method="post">
			<label>
			Name
			</label>
			<input type="text" name="name" /> <br /> <br />
			<label>
			Password
			</label>
			<input type="password" name="password" /><br /><br />
			<input type="submit"/>
		</form>
	</div>
	<%@ include file="common/footer.jspf" %>