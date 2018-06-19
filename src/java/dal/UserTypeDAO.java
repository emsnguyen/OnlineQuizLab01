/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserType;

/**
 *
 * @author lenovo
 */
public class UserTypeDAO extends BaseDAO {

    public ArrayList<UserType> getAll() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<UserType> types = new ArrayList<>();
        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "  FROM [UserType]";
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserType t = new UserType();
                t.setID(rs.getInt("ID"));
                t.setName(rs.getString("Name"));
                types.add(t);
            }
            connection.close();
        } catch (SQLException ex) {
            close(connection, ps, rs);
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return types;
    }

}
