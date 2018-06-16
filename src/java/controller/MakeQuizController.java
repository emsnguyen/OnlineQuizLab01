/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuizDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;

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
        String answer = "";
        if (request.getParameter("cb1") != null) {
            answer = optA;
        } else if (request.getParameter("cb2") != null) {
            answer = optB;
        } else if (request.getParameter("cb3") != null) {
            answer = optC;
        } else {
            answer = optD;
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
        QuizDAO qDB = new QuizDAO();
        try {
            qDB.insertQuiz(q);
            //back to Home
            getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/ErrorPage.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
