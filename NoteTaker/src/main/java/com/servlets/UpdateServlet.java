package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Session s = FactoryProvider.getFactory().openSession(); 
	        Transaction tx = s.beginTransaction();
	        
	        int noteId = Integer.parseInt(request.getParameter("n_id"));
	        Note note = (Note)(s.get(Note.class, noteId));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
	        note.setTitle(title);
	        note.setContent(content);
	        s.save(note);
	        tx.commit();
	        s.close();
	        response.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
}
