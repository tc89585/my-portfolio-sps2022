package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.sps.servlets.Task;

@WebServlet("/list-responses")
public class ListResponsesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query =
            Query.newEntityQueryBuilder().setKind("Form").build();
        QueryResults<Entity> results = datastore.run(query);
    
        List<Task> messages = new ArrayList<>();
        while (results.hasNext()) {
          Entity entity = results.next();

          String message = entity.getString("message");
    
          Task task = new Task(message);
          messages.add(task);
        }
    
        Gson gson = new Gson();
    
        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(messages));        
    }
}
