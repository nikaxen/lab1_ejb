
package MBEANS;

import Singleton.Single;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;


@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    @EJB
    private ISelectBean selectbean;
    @EJB
    private Singleton.Single single;
    private MODELS.User selectedUser;
    
    public SessionBean() {
    }

    public MODELS.User getSelectedUser() {
        return selectedUser;
    }

    public void setSelected(int id) {
        selectbean.setSelected(id);
        selectedUser = selectbean.getSelectedUser();
    }
    public int getNumber(){
        return single.getCount();
    }
    
}
