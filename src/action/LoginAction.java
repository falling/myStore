package action;

import bean.Usertablebean;
import dao.UserDAO;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        Usertablebean loginUser = dao.getByUsername(user);
        if (loginUser != null) {
            ServletActionContext.getRequest().getSession().setAttribute("user",loginUser);
            return loginUser.getPermission();
        }
        return "error";
    }
}
