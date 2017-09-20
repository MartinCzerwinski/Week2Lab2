package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String loggedout = request.getParameter("loggedout");
        if(loggedout == "1")
        {
            request.setAttribute("message", "Successfully Logged Out");
            getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        
        if (username.isEmpty() && password.isEmpty())
        {
            request.setAttribute("message", "Username and/or Password field cannot be empty");
            getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
        }
        if (userService.login(username, password) == true)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
        }
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("message", "Invalid Username/Password");
        getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
        
    }
}
