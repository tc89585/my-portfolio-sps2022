package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String [] messagesArray = {
        "Hello, from the other side.",
        "Whats love got to do with it.",
        "One day, very soon, I will be super rich."
    };
    
    Gson gson = new Gson();
    String json = gson.toJson(messagesArray);

    response.setContentType("application/json");
    response.getWriter().print(json);
  }
}
