/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuizDAO;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;
import model.User;

/**
 *
 * @author lenovo
 */
public class MakeQuizController extends BaseController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //check if user's logged in as teacher role
        HttpSession session = request.getSession();
        Object oTypeID = session.getAttribute("typeID");
        if (oTypeID == null || Integer.parseInt(oTypeID.toString()) != 2) {
            getServletContext().getRequestDispatcher("/LimitedAccessPage.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);

    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get request parameters
        String content = request.getParameter("content");
        String optA = request.getParameter("optA");
        String optB = request.getParameter("optB");
        String optC = request.getParameter("optC");
        String optD = request.getParameter("optD");
        request.setAttribute("optA", optA);
        request.setAttribute("optB", optB);
        request.setAttribute("optC", optC);
        request.setAttribute("optD", optD);
        request.setAttribute("content", content);
        if (content == null) {
            request.setAttribute("errorContent", "Content cannot be null");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        if (optA == null) {
            request.setAttribute("errorOptA", "Option 1 cannot be null");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        if (optB == null) {
            request.setAttribute("errorOptB", "Option 2 cannot be null");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        if (optC == null) {
            request.setAttribute("errorOptC", "Option 3 cannot be null");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        if (optD == null) {
            request.setAttribute("errorOptD", "Option 4 cannot be null");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        String answer = "";
        if (request.getParameter("cb1") != null) {
            answer = optA;
        } else if (request.getParameter("cb2") != null) {
            answer = optB;
        } else if (request.getParameter("cb3") != null) {
            answer = optC;
        } else if (request.getParameter("cb4") != null) {
            answer = optD;
        }
        if (answer.equals("")) {
            request.setAttribute("errorCorrectAnswer", "Please choose at least one answer");
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuiz.jsp").forward(request, response);
            return;
        }
        //insert new quiz to db
        Quiz q = new Quiz();
        q.setContent(content);
        q.setOptA(optA);
        q.setOptB(optB);
        q.setOptC(optC);
        q.setOptD(optD);
        q.setAnswer(answer);
        q.setDateCreated(new java.util.Date());
        //set creator ID
        int creatorID = (int) request.getSession().getAttribute("userID");
        User u = new User();
        u.setID(creatorID);
        q.setCreator(u);
        QuizDAO qDB = new QuizDAO();
        try {
            qDB.insertQuiz(q);
            //fw to makequizsuccess page
            request.setAttribute("q", q);
            getServletContext().getRequestDispatcher("/WEB-INF/MakeQuizSuccess.jsp").forward(request, response);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
