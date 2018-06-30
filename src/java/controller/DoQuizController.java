package controller;

import dal.QuizDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;
import utils.ShowResult;

public class DoQuizController extends BaseController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession(true);
            if (session.getAttribute("mark") != null) {
                session.removeAttribute("mark");
            }
            int noOfQuestions = (int) session.getAttribute("noOfQuestions");
            QuizDAO qDB = new QuizDAO();
            ArrayList<Quiz> quizzes = qDB.getAll(noOfQuestions);
            session.setAttribute("quizzes", quizzes);
            request.setAttribute("q", quizzes.get(0));
            session.setAttribute("currentQuiz", 0);
            session.setAttribute("mark", 0);
            session.setAttribute("startDate", new Date());
            getServletContext().getRequestDispatcher("/WEB-INF/DoQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DoQuizController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }
    public long getDateDiff(Date startDate, Date endDate, TimeUnit unit) {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        long diffInMinutes = unit.convert(diffInMillis, TimeUnit.MILLISECONDS);
        System.out.println("time diff: " + diffInMinutes);
        return diffInMinutes;
    }
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            
            //verify time in server
            Date startDate = (Date) session.getAttribute("startDate");
            Date endDate = new Date();
            long timeElapsed = getDateDiff(startDate, endDate, TimeUnit.SECONDS);
            int currentQuizIndex = (int) session.getAttribute("currentQuiz");
            //save all the quizzes to session so no need to access db everytime
            String result = request.getParameter("result");
            ArrayList<Quiz> quizzes = (ArrayList<Quiz>) session.getAttribute("quizzes");
            int mark;
            try {
                mark = (int) session.getAttribute("mark");
            } catch (Exception e) {
                response.sendRedirect("takequiz");
                return;
            }

            String answer = quizzes.get(currentQuizIndex).getAnswer();
            if (result.equals(answer) && timeElapsed <= 60) {
                //if user got a correct answer, add one point to mark
                mark = mark + 1;
                session.setAttribute("mark", mark);
            }
            if (currentQuizIndex == quizzes.size() - 1) {
                //user answer his chosen number of questions, show result
                float fResult = ShowResult.getResult(mark, currentQuizIndex + 1);
                String sResult = ShowResult.getStringResult(fResult);
                String percentResult = String.format("%.0f", fResult * 10);
                //save result to db
                int userID = (int) session.getAttribute("userID");
                new UserDAO().saveTestResult(fResult, userID);
                request.setAttribute("fResult", String.format("%.2f", fResult));
                request.setAttribute("percentResult", percentResult);
                request.setAttribute("sResult", sResult);
                session.removeAttribute("mark");
                getServletContext().getRequestDispatcher("/WEB-INF/TestResult.jsp").forward(request, response);

            } else {
                //fetch next question
                currentQuizIndex++;
                session.setAttribute("currentQuiz", currentQuizIndex);
                request.setAttribute("q", quizzes.get(currentQuizIndex));
                getServletContext().getRequestDispatcher("/WEB-INF/DoQuiz.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(DoQuizController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
