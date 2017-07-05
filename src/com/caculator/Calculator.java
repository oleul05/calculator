package com.caculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator") //Name of the servlet
public class Calculator extends HttpServlet {

	// It's servlet post method by which we get all the form value
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // To print any text in servlet we use PrintWriter

		//Check the button value of the form if it is not null then we perform the following operation.
		if (request.getParameter("bouton") != null) { //request is the HttpServletRequest class object and .getParameter used to get the value of button

			String s = request.getParameter("bouton"); //put the value of button in String s
			Double nombre1, nombre2; //  Declare two Integer variable which we want to calculate
			
			String num1 = request.getParameter("nombre1"); // Get the value of number 1 from form
			String num2 = request.getParameter("nombre2"); // Get the value of number 1 from form
			
			request.setAttribute("num1", num1); //Pass the number 1 value to the jsp
			request.setAttribute("num2", num2); //Pass the number 2 value to the jsp

			if (request.getParameter("nombre1").equals("")) { // Check the number 1 is empty or not
				nombre1 = (double) 0;
			} else
				nombre1 = Double.valueOf(request.getParameter("nombre1")); //if number 1 from form is not empty then set the value to variable number1

			if (request.getParameter("nombre2").equals("")) {
				nombre2 = (double) 0;
			} else
				nombre2 = Double.valueOf(request.getParameter("nombre2"));

			if (s.equals("+")) { // Check the button value is +, or not if button value is plus then add the two number
				double add = CalculatorDao.add(nombre1, nombre2);
				request.setAttribute("add", add); // pass the add object to jsp to show the addition
			}

			else if (s.equals("-")) { // if the button value equal - then subtract
				double sub = CalculatorDao.sub(nombre1, nombre2);
				request.setAttribute("sub", sub); // pass the sub object to jsp to show the subtraction
				
			}

			else if (s.equals("*")) { // if the button value equal * then Multiply
				double mul = CalculatorDao.multiplication(nombre1, nombre2);
				request.setAttribute("mul", mul);
				
			} else if (s.equals("/")) { // if the button value equal / then divide
				double div = CalculatorDao.div(nombre1, nombre2);
				request.setAttribute("div", div);
				
			}

			else if (s.equals("Effacer")) { // if the button value equal Effacer then then print empty

				System.out.print("  ");

			}
			
		}
		
		request.getRequestDispatcher("index.jsp").include(request, response); //After form submit redirect the page to index.jsp

	}
}
