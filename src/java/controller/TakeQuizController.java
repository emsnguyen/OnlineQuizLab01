package controller;

import dal.QuizDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;
import utils.ShowResult;

public class TakeQuizController extends BaseController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            QuizDAO qDB = new QuizDAO();
            int availableQuestions = qDB.countRecords();
            int noOfQuestions;
            String sNoofQuestions = request.getParameter("chosenQuizzes");
            if (sNoofQuestions == null) {
                request.setAttribute("error", "No of questions is null");
                getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
                return;
            }
            try {
                noOfQuestions = Integer.parseInt(sNoofQuestions);
            } catch (NumberFormatException ex) {
                request.setAttribute("error", "You must enter a valid integer");
                Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
                return;
            }
            if (noOfQuestions >= 0 && noOfQuestions <= availableQuestions) {
                session.setAttribute("noOfQuestions", noOfQuestions);
                response.sendRedirect("doquiz");
            } else {
                //return to old page without noOfQuestions to ask user to choose again
                request.setAttribute("error", "You must choose a number between 0 and " + availableQuestions);
                getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
