package com.inforcap.joseignacio.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatNumber
 */
@WebServlet("/GreatNumber")
public class GreatNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String btn = request.getParameter("btnSubmit");
		int valorAleat = (int) Math.floor(Math.random() * 99 + 1);
		int valAleatGuardado = (int) session.getAttribute("valorAleat");
		
		
		if(btn != null) {
			if (session.getAttribute("valorAleat") == null) {
				session.setAttribute("valorAleat", valorAleat);
			} else {
				session.setAttribute("valorAleat", valAleatGuardado);
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String btn = request.getParameter("btnSubmit");
		String validaciones = "";
		int number = Integer.parseInt(request.getParameter("number"));
		int valAleatGuardado = (int) session.getAttribute("valorAleat");
		
		if(btn != null) {

			if(number == valAleatGuardado) {
	        	validaciones += "<h1>"+number+" was the number!</h1>";
	        	
	        }
			
			if(number == 0) {
	        	validaciones += "<h1>You must enter a number</h1>";
	        }
			
			if(number > valAleatGuardado) {
				validaciones += "<h1>Too high!</h1>";
			}
			if(number < valAleatGuardado) {
				validaciones += "<h1>Too loow!</h1>";
			}
			
			request.setAttribute("validaciones", validaciones);
	        request.setAttribute("number", number);
	        
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

}
