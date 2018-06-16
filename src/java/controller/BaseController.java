package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "BaseController", urlPatterns = {"/BaseController"})
public abstract class BaseController extends HttpServlet {
    protected boolean authenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        return session.getAttribute("username") != null;
    }
    protected abstract void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    protected abstract void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticate(request, response)) {
            handleGet(request, response);
        } else {
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (authenticate(request, response)) {
            handlePost(request, response);
        } else {
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
