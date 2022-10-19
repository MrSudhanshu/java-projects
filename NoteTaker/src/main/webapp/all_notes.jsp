<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.entities.*"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>

<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="contaier">

		<%@include file="navbar.jsp"%>
		
	</div>
	<h1>All Notes :-</h1>

	<div class="row">
		<div class="col-12">


			<%
			Session s = FactoryProvider.getFactory().openSession();
			Query q = s.createQuery("from Note");
			List<Note> list = q.list();
			System.out.print(list.size());
			if(list.size() < 1){
				out.print("<div style='"
		                + "text-align:center;"
		                + "margin-top:10em;'>"
		                + "<h1>No Saved Notes !</h1>");
			}
			for (Note note : list) {
			%>
			<div class="card mt-3" >
				<img class="card-img-top mt-4 ml-auto mr-auto" src="images/noteicon.png" style="max-width:50px" alt="Card image cap">
				<div class="card-body p-5" style="text-align:center">
					<h4 class="card-title"><%=note.getTitle()%></h4>
					<p class="card-text"><%=note.getContent()%></p>	
					<h6>Note Added Date :<b class="text-primary"> <%= new SimpleDateFormat("yyyy-MM-dd").format(note.getAddedDate()) %></b></h6>
					<h6>Note Added Time :<b class="text-primary"> <%= new SimpleDateFormat("HH:mm").format(note.getAddedDate()) %></b></h6>
					<div class="container text-center" >
					<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger mr-1">Delete</a>                                                            
					<a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary ml-1">Update</a>
					</div>
				
				</div>
			</div>

			<%
			}
			s.close();
			%>
		</div>
	</div>


</body>
</html>