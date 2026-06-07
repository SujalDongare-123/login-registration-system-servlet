<%@page import="java.util.List"%>
<%@page import="in.soft.entity.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Users</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/style.css">

</head>

<body>

	<nav class="navbar navbar-dark px-4">

		<span class="navbar-brand"> All Users </span>

	</nav>

	<div class="container mt-5">

		<%
		List<User> list = (List<User>) request.getAttribute("data");
		%>

		<div class="table-container">

			<table class="table custom-table text-center">

				<thead>

					<tr>

						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Action</th>

					</tr>

				</thead>

				<tbody>

					<%
					for (User u : list) {
					%>

					<tr>

						<td><%=u.getId()%></td>
						<td><%=u.getName()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getPassword()%></td>

						<td><a
							href="update.html?id=<%=u.getId()%>&name=<%=u.getName()%>&email=<%=u.getEmail()%>&password=<%=u.getPassword()%>"
							class="btn btn-warning btn-sm"> Update </a> <a
							href="delete?id=<%=u.getId()%>" class="btn btn-danger btn-sm">
								Delete </a></td>

					</tr>

					<%
					}
					%>

				</tbody>

			</table>

			<div class="text-center mt-4">

				<a href="index.html" class="btn btn-dark">  Back to Home </a>

			</div>

		</div>

	</div>

</body>
</html>