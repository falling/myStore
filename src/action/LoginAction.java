package action;

import bean.Usertablebean;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import util.SpringGetBeanUtil;

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
        UserService service = (UserService) SpringGetBeanUtil.getBean("userService");
        Usertablebean loginUser = service.login(user);
        if (loginUser != null) {
            ServletActionContext.getRequest().getSession().setAttribute("user", loginUser);
            return loginUser.getPermission();
        }
        ServletActionContext.getRequest().setAttribute("msg", "账号或者密码错误");
        return "error";
    }
}
