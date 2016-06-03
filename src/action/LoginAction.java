package action;

import bean.Usertablebean;
import dao.UserDAO;
import org.apache.struts2.ServletActionContext;

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
        UserDAO dao = new UserDAO();
        Usertablebean loginUser = dao.login(user);
        if (loginUser != null) {
            ServletActionContext.getRequest().getSession().setAttribute("user",loginUser);
            return loginUser.getPermission();
        }
        ServletActionContext.getRequest().setAttribute("msg","账号或者密码错误");
        return "error";
    }
}
