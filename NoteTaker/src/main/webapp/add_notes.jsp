<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Note</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="contaier">

		<%@include file="navbar.jsp"%>


		<h1 style="text-align: center;">Please Fill Your Note Details</h1>


		<!-- login form -->
		<form action="SaveNoteServlet" method=post>
			<div class="form-group">
				<label for="exampleInputEmail1">Note Title</label> <input
					required="required" type="text" name="title" class="form-control"
					id="title" aria-describedby="emailHelp"
					placeholder="Enter Your Note Title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Note Content</label>
				<textarea required="required" name="content" id="content"
					class="form-control" style="height: 300px"
					placeholder="Enter Your Note Content Here"></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Add Note</button>
			</div>
		</form>

	</div>
</body>
</html>