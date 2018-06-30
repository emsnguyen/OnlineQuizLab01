package controller;

import dal.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO uDB = new  UserDAO();
        User u;
        try {
            if (!uDB.usernameExisted(username)) {
                request.setAttribute("invalidUsername", "Username does not exist");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
                return;
            }
            u = uDB.checkLogin(username, password);
            if (u != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", u.getUsername());
                session.setAttribute("userID", u.getID());
                session.setAttribute("typeID", u.getTypeID());
                getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
            } else {
                request.setAttribute("invalidPassword", "Password is wrong");
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
