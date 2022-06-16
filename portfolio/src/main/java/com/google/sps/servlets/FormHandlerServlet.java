package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Key;


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

    //instance of datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    //set the KIND of the key
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");
  
    //create entitiy with a key
    FullEntity formSubmissionEntity = 
        Entity.newBuilder(keyFactory.newKey())
        //set the properties
        .set("name", nameValue)
        .set("email", emailValue)
        .set("subject", subjectValue)
        .set("message", messageValue)
        .build();

    //store entity
    datastore.put(formSubmissionEntity);

    //redirect to home
    response.sendRedirect("https://tcurry-sps-summer22.appspot.com");
  }


}//FormHandlerServlet