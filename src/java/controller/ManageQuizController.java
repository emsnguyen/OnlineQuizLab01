package controller;

import dal.QuizDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;
import utils.HTMLHelper;

public class ManageQuizController extends BaseController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //check if user's logged in as teacher role
            HttpSession session = request.getSession();
            Object oTypeID = session.getAttribute("typeID");
            if (oTypeID == null || Integer.parseInt(oTypeID.toString()) != 2) {
                getServletContext().getRequestDispatcher("/LimitedAccessPage.jsp").forward(request, response);
                return;
            }
            //insert paging
            QuizDAO qDB = new QuizDAO();
            ArrayList<Quiz> quizzes;
            int pageIndex;
            String sPageIndex = request.getParameter("pageIndex");
            if (sPageIndex == null) {
                pageIndex = 1;
            } else {
                pageIndex = Integer.parseInt(sPageIndex);
            }
            int pageGap = Integer.parseInt(QuizDAO.pageGap);
            int pageSize = Integer.parseInt(QuizDAO.pageSize);
            int start = (pageIndex - 1) * pageSize + 1;
            int end = start + pageSize - 1;
            int creatorID = (int) request.getSession().getAttribute("userID");
            quizzes = qDB.getAll(start, end, creatorID);
            request.setAttribute("quizzes", quizzes);
            request.setAttribute("pageIndex", pageIndex);
            //count all records of this creator to get an idea of the last and first page to customize
            //for display purpose only
            int totalRecords = qDB.countRecords(creatorID);
            int totalPage = totalRecords/pageSize + ((totalRecords%pageSize) > 0 ? 1 : 0);
            if (pageIndex > totalPage) {
                throw new Exception();
            }
            String paging = HTMLHelper.paging(totalPage, pageGap, pageIndex);
            request.setAttribute("paging", paging);
            getServletContext().getRequestDispatcher("/WEB-INF/ManageQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
