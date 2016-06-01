package action;

import bean.Bean;
import bean.Usertablebean;
import dao.DAO;
import dao.DAOImpl;

/**
 * Created by falling on 2016/6/1.
 */
public class LoginAction {
    private Usertablebean user;

    public Usertablebean getUser() {
        return user;
    }

    public void setUser(Usertablebean user) {
        this.user = user;
    }

    public String execute() throws Exception {
        System.out.println(user.getUsername() + user.getPassword());
        DAO dao = new DAOImpl();
        Bean bean = new Usertablebean();
        bean.setId(1);
        Usertablebean a  = (Usertablebean) dao.get(bean);
        System.out.println(a.getUsername());
        if(user.getUsername().equals("test"))
            return "error";
        return "success";
    }
}
