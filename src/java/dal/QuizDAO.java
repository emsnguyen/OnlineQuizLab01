package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quiz;
import model.User;

public class QuizDAO extends BaseDAO {
    public User getUser(int userID) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT ID, "
                    + "       [Username]\n"
                    + "      ,[Password]\n"
                    + "      ,[TypeID]\n"
                    + "      ,[Email]\n"
                    + "  FROM [UserTBL] \n"
                    + "  where ID = ?\n";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setID(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setTypeID(rs.getInt(4));
                u.setEmail(rs.getString(5));
                return u;
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }
    public ArrayList<Quiz> getAll() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Content]\n"
                    + "      ,[OptA]\n"
                    + "      ,[OptB]\n"
                    + "      ,[OptC]\n"
                    + "      ,[OptD]\n"
                    + "	  , Answer, DateCreated, CreatorID\n"
                    + "  FROM [Quiz] ORDER BY newid()";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setID(rs.getInt(1));
                q.setContent(rs.getString(2));
                q.setOptA(rs.getString(3));
                q.setOptB(rs.getString(4));
                q.setOptC(rs.getString(5));
                q.setOptD(rs.getString(6));
                q.setAnswer(rs.getString(7));
                q.setDateCreated(rs.getDate(8));
                int creatorID = rs.getInt("CreatorID");
                q.setCreator(getUser(creatorID));
                quizzes.add(q);
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return quizzes;
    }

    public ArrayList<Quiz> getAll(int noOfQuestions) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT TOP (?) "
                    + " [ID]\n"
                    + "      ,[Content]\n"
                    + "      ,[OptA]\n"
                    + "      ,[OptB]\n"
                    + "      ,[OptC]\n"
                    + "      ,[OptD]\n"
                    + "	  , Answer, DateCreated, CreatorID\n"
                    + "  FROM [Quiz] ORDER BY newid()";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, noOfQuestions);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setID(rs.getInt(1));
                q.setContent(rs.getString(2));
                q.setOptA(rs.getString(3));
                q.setOptB(rs.getString(4));
                q.setOptC(rs.getString(5));
                q.setOptD(rs.getString(6));
                q.setAnswer(rs.getString("Answer"));
                q.setDateCreated(rs.getDate("DateCreated"));
                int creatorID = rs.getInt("CreatorID");
                q.setCreator(getUser(creatorID));
                quizzes.add(q);
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return quizzes;
    }

    public boolean insertQuiz(Quiz q) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "INSERT INTO [Quiz]\n"
                    + "           ([Content]\n"
                    + "           ,[OptA]\n"
                    + "           ,[OptB]\n"
                    + "           ,[OptC]\n"
                    + "           ,[OptD]\n"
                    + "           ,[Answer]\n"
                    + "           ,[DateCreated], CreatorID)\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?, ?)";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, q.getContent());
            ps.setString(2, q.getOptA());
            ps.setString(3, q.getOptB());
            ps.setString(4, q.getOptC());
            ps.setString(5, q.getOptD());
            ps.setString(6, q.getAnswer());
            ps.setDate(7, new Date(q.getDateCreated().getTime()));
            ps.setInt(8, q.getCreator().getID());
            int retVal = ps.executeUpdate();
            if (retVal > 0) {
                flag = true;
            }
            close(connection, ps, rs);
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return flag;
    }

    public int countRecords() throws Exception {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "select count(ID) as total from Quiz";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
            close(connection, ps, rs);
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return count;
    }

    public ArrayList<Quiz> getAll(int start, int end, int creatorID) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT rn, [ID]\n"
                    + "     ,[Content]\n"
                    + "      ,[OptA]\n"
                    + "      ,[OptB]\n"
                    + "      ,[OptC]\n"
                    + "      ,[OptD]\n"
                    + "      ,[Answer]\n"
                    + "      ,[DateCreated]\n"
                    + "      ,[CreatorID]\n"
                    + "	  from (\n"
                    + "		select ROW_NUMBER() over (order by ID asc) as \n"
                    + "		rn, [ID]\n"
                    + "     ,[Content]\n"
                    + "      ,[OptA]\n"
                    + "      ,[OptB]\n"
                    + "      ,[OptC]\n"
                    + "      ,[OptD]\n"
                    + "      ,[Answer]\n"
                    + "      ,[DateCreated]\n"
                    + "      ,[CreatorID] from Quiz\n"
                    + "	  \n"
                    + ") as x\n"
                    + "where rn between ? and ? and CreatorID = ?";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, start);
            ps.setInt(2, end);
            ps.setInt(3, creatorID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setID(rs.getInt("ID"));
                q.setContent(rs.getString("Content"));
                q.setOptA(rs.getString("OptA"));
                q.setOptB(rs.getString("OptB"));
                q.setOptC(rs.getString("OptC"));
                q.setOptD(rs.getString("OptD"));
                q.setAnswer(rs.getString("Answer"));
                q.setDateCreated(rs.getDate("DateCreated"));
                q.setCreator(getUser(rs.getInt("CreatorID")));
                quizzes.add(q);
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return quizzes;
    }

    public int countRecords(int creatorID) throws Exception {
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "select count(ID) as total from Quiz WHERE CreatorID = ?";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, creatorID);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
            }
            close(connection, ps, rs);
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return count;
    }
}
