package action;

import bean.Usertablebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;
import util.SpringGetBeanUtil;

/**
 * Created by falling on 2016/6/3.
 */

public class RegisterAction {
    private Usertablebean bean;

    public Usertablebean getBean() {
        return bean;
    }

    public void setBean(Usertablebean bean) {
        this.bean = bean;
    }

    public String execute() throws Exception {
        UserService userService = (UserService) SpringGetBeanUtil.getBean("LoginService");

        if (userService.register(bean)) {
            return "success";
        }
        return "error";
    }
}
