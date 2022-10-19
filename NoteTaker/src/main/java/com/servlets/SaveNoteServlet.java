package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.*;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
	    super();
	    // TODO Auto-generated constructor stub
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    try {
	        //title, content fetch
	        String title = request.getParameter("title");
	        String content = request.getParameter("content");
	        Note note = new Note(title, content, new Date());
//	        System.out.println(note.getId()+" "+note.getContent()+" "+note.getTitle()+" "+note.getAddedDate());
	        
//	        Hibernate saving
	        Session s = FactoryProvider.getFactory().openSession();
	        Transaction tx = s.beginTransaction();
	        s.save(note);
	        tx.commit();
	        s.close();
	        
	        
	        
	        out.print("<div style='"
	                + "text-align:center;"
	                + "margin-top:10em;'>"
	                + "<h1>Your Note Saved Successfully !</h1>"
	                + "<a href='add_notes.jsp' "
	                + "style='text-decoration:none;"
	                + "border:black solid 2px;"
	                + " border-radius:4px;"
	                + "padding : 4px"
	                + "'>Add New Note</a>               "
	                + "<a href='all_notes.jsp' "
	                + "style='text-decoration:none;"
	                + "border:black solid 2px;"
	                + "border-radius:4px;"
	                + "padding : 4px"
	                + "'>Show All Notes</a>"
	                + "</div>");
	        
	        
	    }
	    catch (Exception e) {
            // TODO: handle exception
	        out.print(e);
        }
	}


}
