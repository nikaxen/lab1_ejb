
package DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DAORemote {
    public List<MODELS.User> ListOfUsers() throws SQLException, ParseException;
    public MODELS.User GetByID(int uid) throws SQLException, ParseException;
    public void AddUser(String fio, String email, String password) throws SQLException, ParseException;
}
