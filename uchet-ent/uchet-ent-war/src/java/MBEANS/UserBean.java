package MBEANS;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "userBean")
@RequestScoped
public class UserBean {
    private String fio;
    private String email;
    private String password;
    private List<MODELS.User> UserList;
    
    @EJB
    private DAO.DAORemote uDAO;
    
    @PostConstruct
    public void SetUserList(){
        try {
            UserList=uDAO.ListOfUsers();
        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<MODELS.User> getAllUsers() throws SQLException, ParseException{
        return UserList;
    }
    
    public String AddNewUser() throws SQLException, ParseException {
       
        uDAO.AddUser(fio,email,password);
        return "view.xhtml";
    }
    
    public UserBean() {
        //
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
