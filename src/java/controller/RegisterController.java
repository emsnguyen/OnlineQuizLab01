/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import dal.UserTypeDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.InputValidator;

public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserTypeDAO tDB = new UserTypeDAO();
            request.setAttribute("types", tDB.getAll());
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UserTypeDAO tDB = new UserTypeDAO();
            request.setAttribute("types", tDB.getAll());
            //get request paprameters
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String sTypeID = request.getParameter("typeID");
            UserDAO uDB = new UserDAO();
            boolean hasError = false;
            //check if input is valid
            if (uDB.usernameExisted(username)) {
                request.setAttribute("invalidUsername", "Username existed");
                hasError = true;
            }
            String checkUsername = InputValidator.isValidString(username, 8, 20, "Username");
            if (!checkUsername.equals("")) {
                request.setAttribute("invalidUsername", checkUsername);
                hasError = true;
            }
            String checkPassword = InputValidator.isValidPassword(password);
            if (!checkPassword.equals("")) {
                request.setAttribute("invalidPassword", checkPassword);
                hasError = true;
            }
            int typeID = 0;
            if (sTypeID == null) {
                request.setAttribute("invalidTypeID", "Must choose a type");
                hasError = true;
            } else {
                typeID = Integer.parseInt(sTypeID);
            }
            String checkEmail = InputValidator.isValidEmail(email);
            if (!checkEmail.equals("")) {
                request.setAttribute("invalidEmail", checkEmail);
                hasError = true;
            }
            if (hasError) {
                request.setAttribute("email", email);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
                return;
            }
            //no error existed, ready to insert
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            u.setEmail(email);
            u.setTypeID(typeID);
            uDB.insert(u);
            int userID = uDB.getUserID(username);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userID", userID);
            session.setAttribute("typeID", u.getTypeID());
            //redirect to takequiz page
            getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/WEB-INF/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
