
package MBEANS;

import MODELS.User;
import Singleton.Single;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

@Stateful
@Named(value="selectBean")
@ConversationScoped

public class SelectBean implements ISelectBean, Serializable{

    @Inject
    private Conversation conv;
    @EJB
    private DAO.DAORemote dao;
    private MODELS.User selectedUser;
    
    
    @Override
    public void setSelected(int id) {
        if(conv.isTransient()){
            conv.begin();
        }
        try {
            selectedUser=dao.GetByID(id);
            conv.end();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./selected.xhtml");
        } catch (SQLException | ParseException | IOException ex) {
            Logger.getLogger(SelectBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    @Interceptors(Single.class)
    public MODELS.User getSelectedUser() {
        return selectedUser;
    }
    
    @Override
    public String ReloadPage(){
        return "";
    }
    
}
