<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.helper.*"%>
	<%@page import="com.entities.*"%>
	<%@page import="org.hibernate.Session"%>
	<%@page import="org.hibernate.Transaction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="contaier">

		<%@include file="navbar.jsp"%>

	</div>


	<h1>Edit Your Note:-</h1><br>
	
	<%
        int noteId = Integer.parseInt(request.getParameter("note_id").trim());
        Session s = FactoryProvider.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Note note = (Note)(s.get(Note.class, noteId));            
	%>
	
	
	<form action="UpdateServlet" method=post>
		<div class="form-group">
			<label for="exampleInputEmail1">Note Title</label> <input
				required="required" type="text" name="title" class="form-control"
				id="title" aria-describedby="emailHelp"
				placeholder="Enter Your Note Title"
				value="<%= note.getTitle()%>">
		</div>
		<input type="hidden" name="n_id" value=<%=note.getId() %>>
		<div class="form-group">
			<label for="exampleInputPassword1">Note Content</label>
			<textarea required="required" name="content" id="content"
				class="form-control" style="height: 300px"
				placeholder="Enter Your Note Content Here"
				><%=note.getContent() %></textarea>
		</div>
		<div class="container text-center">
			<button type="submit" class="btn btn-success" >Save Your Note</button>
		</div>
	</form>
	
	

</body>
</html>