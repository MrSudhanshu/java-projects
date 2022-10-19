<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Note Taker : Home</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="contaier">
		<%@include file="navbar.jsp"%>
	</div>
	<div class="card">
		<img alt=""
			style="max-width: 100%; height: 500px; width: 500px; margin: auto"
			src="images/noteicon.png">
		<form action="add_notes.jsp" method=post>
			<div class="container text-center pt-3 pb-3">
				<button type="submit" class="btn btn-success">Start Adding Notes</button>
			</div>
		</form>
	</div>
</body>
</html>