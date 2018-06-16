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
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession(true);
            String sNoofQuestions = request.getParameter("chosenQuizzes");
            if (session.getAttribute("mark") != null) {
                session.removeAttribute("mark");
            }
            if (sNoofQuestions == null) {
                getServletContext().getRequestDispatcher("/WEB-INF/TakeQuiz.jsp").forward(request, response);
                return;
            }
            int noOfQuestions = Integer.parseInt(sNoofQuestions);
            QuizDAO qDB = new QuizDAO();

            //get list of quizzes from db
            ArrayList<Quiz> quizzes;
            int availableQuestions = qDB.countRecords();
            if (noOfQuestions > 0 && noOfQuestions <= availableQuestions) {

                request.setAttribute("currentQuiz", 0);
                session.setAttribute("mark", 0);
                //save all the quizzes to session so no need to access db everytime
                quizzes = qDB.getAll(noOfQuestions);
                session.setAttribute("quizzes", quizzes);
                request.setAttribute("q", quizzes.get(0));
                getServletContext().getRequestDispatcher("/WEB-INF/DoQuiz.jsp").forward(request, response);
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
    protected void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            String currentQuiz = request.getParameter("currentQuiz");
            int currentQuizIndex = Integer.parseInt(currentQuiz);
            String result = request.getParameter("result");
            HttpSession session = request.getSession();
            ArrayList<Quiz> quizzes = (ArrayList<Quiz>) session.getAttribute("quizzes");
            int mark = Integer.parseInt(session.getAttribute("mark").toString());
            String answer = quizzes.get(currentQuizIndex).getAnswer();
            if (result.equals(answer)) {
                //if user got a correct answer, add one point to mark
                mark = mark + 1;
                session.setAttribute("mark", mark);
            }
            if (currentQuizIndex == quizzes.size() - 1) {
                //user answer his chosen number of questions, show result
                float fResult = ShowResult.getResult(mark, currentQuizIndex + 1);
                String sResult = ShowResult.getStringResult(fResult);
                
                //save result to db
                int userID = (int) session.getAttribute("userID");
                new UserDAO().saveTestResult(fResult, userID);
                request.setAttribute("fResult", String.format("%.2f", fResult));
                request.setAttribute("sResult", sResult);
                getServletContext().getRequestDispatcher("/WEB-INF/TestResult.jsp").forward(request, response);

            } else {
                //fetch next question
                currentQuizIndex++;
                request.setAttribute("currentQuiz", currentQuizIndex);
                request.setAttribute("q", quizzes.get(currentQuizIndex));
                getServletContext().getRequestDispatcher("/WEB-INF/DoQuiz.jsp").forward(request, response);
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
