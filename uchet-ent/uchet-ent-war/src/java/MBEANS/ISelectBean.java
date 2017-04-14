
package MBEANS;

import javax.ejb.Local;

@Local
public interface ISelectBean {
    public MODELS.User getSelectedUser();
    public void setSelected(int id);
}
