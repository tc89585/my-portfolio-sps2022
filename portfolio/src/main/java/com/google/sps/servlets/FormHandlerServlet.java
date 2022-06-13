package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//handle POST requests for the /form-handler URL
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String nameValue = request.getParameter("name-field");
    String emailValue = request.getParameter("email-field");
    String subjectValue = request.getParameter("subject-field");
    String messageValue = request.getParameter("message-field");

    String serverLogValue = "the server received:" + "\n" + 
                            "name: " + nameValue + "\n" +
                            "email: " + emailValue + "\n" + 
                            "subject: " + subjectValue + "\n" +
                            "message: " + messageValue + "\n";

    // Print the value so you can see it in the server logs.
    //stores in server logs. can be viewed on google log explorer
    System.out.println("submitted: " + "\n" + serverLogValue);

    // Write the value to the response so the user can see it.
    //response.getWriter().println("You submitted: " + serverLogValue);
    response.sendRedirect("https://tcurry-sps-summer22.appspot.com/thanks.html");
  }


}//FormHandlerServlet