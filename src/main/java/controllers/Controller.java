package controllers;

import com.example.lab10_JSP.DB;
import com.example.lab10_JSP.command.factory.Command;
import com.example.lab10_JSP.command.factory.CommandResult;
import com.example.lab10_JSP.command.factory.CommandFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

@WebServlet(name = "controllers.Controller", value = "/controllers.Controller")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    public void processRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String command = request.getParameter(COMMAND);
        Command action = CommandFactory.create(command);
        CommandResult commandResult;
        commandResult = action.execute(request, response);

        //Further Redirect or Forward
        try {
            if (commandResult.IsRedirect()) {
                String errorPageUrlPattern = request.getContextPath() + commandResult.getPage();
                sendRedirect(response, errorPageUrlPattern);
            }
            else {
                dispatch(request, response, commandResult.getPage());
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    public void sendRedirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }
}
