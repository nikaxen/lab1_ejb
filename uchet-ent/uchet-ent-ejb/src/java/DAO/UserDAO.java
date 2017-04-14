
package DAO;

import MODELS.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserDAO implements DAORemote {
    @EJB
    private DAO dao;
    
    private PreparedStatement stmt; 
    private ResultSet rs;
    private String SQL;
    @Override
    public List<User> ListOfUsers() throws SQLException, ParseException {
        dao.connect();
        SQL = "SELECT * FROM user";
        
        stmt = dao.connection.prepareStatement(SQL);
        rs = stmt.executeQuery();
        List<MODELS.User> list = new ArrayList<>();
        while (rs.next()) {
        MODELS.User user = new MODELS.User();
        user.setId_user(rs.getInt("id_user"));
        user.setFio(rs.getString("fio"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRolename(rs.getString("rolename"));
            list.add(user);
        }
        dao.disconnect();
        return list;
    }

    @Override
    public void AddUser(String fio, String email, String password) throws SQLException, ParseException {
        dao.connect();
        SQL = "INSERT INTO `user` (id_user, fio, rolename, password, email) VALUES (null,?,?,?,?)";
        stmt = dao.connection.prepareStatement(SQL);
        stmt.setString(1, fio);
        stmt.setString(2, "neizv");
        stmt.setString(3, password);
        stmt.setString(4, email);
        stmt.executeUpdate();
        dao.disconnect();
    }

    @Override
    public User GetByID(int uid) throws SQLException, ParseException {
         dao.connect();
        SQL = "SELECT * FROM user WHERE id_user=" + uid;
        
        stmt = dao.connection.prepareStatement(SQL);
        rs = stmt.executeQuery();
        MODELS.User user = new MODELS.User();
        while (rs.next()) {
        
        user.setId_user(rs.getInt("id_user"));
        user.setFio(rs.getString("fio"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRolename(rs.getString("rolename"));
        }
        dao.disconnect();
        return user;
    }
    
}
