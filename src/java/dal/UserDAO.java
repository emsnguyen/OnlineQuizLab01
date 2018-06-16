package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
public class UserDAO extends BaseDAO {
    
    public User checkLogin(String username, String password) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT ID, "
                    + "       [Username]\n"
                    + "      ,[Password]\n"
                    + "      ,[TypeID]\n"
                    + "      ,[Email]\n"
                    + "  FROM [UserTBL] \n"
                    + "  where Username = ?\n"
                    + "  AND Password = ?";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
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

    public boolean usernameExisted(String username) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "SELECT [ID]\n"
                    + "  FROM [UserTBL] WHERE Username = ?";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return flag;
    }

    public boolean insert(User u)throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "INSERT INTO [UserTBL]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[TypeID]\n"
                    + "           ,[Email])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getTypeID());
            ps.setString(4, u.getEmail());
            int retVal = ps.executeUpdate();
            if (retVal > 0) {
                flag = true;
            }
            close(connection, ps, rs);
        } catch (Exception ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return flag;
    }

    public int getUserID(String username) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        int id = -1;
        try {
            String query = "SELECT [ID]\n"
                    + "  FROM [UserTBL] WHERE Username = ?";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connection.close();
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return id;
    }

    public boolean saveTestResult(float mark, int userID) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            String query = "INSERT INTO [Test_Result]\n"
                    + "           ([UserID]\n"
                    + "           ,[Mark]\n"
                    + "           ,[DateTaken])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?)";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setFloat(2, mark);
            ps.setDate(3, new Date(new java.util.Date().getTime()));
            int retVal = ps.executeUpdate();
            if (retVal > 0) {
                flag = true;
            }
            close(connection, ps, rs);
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return flag;
    }
}
