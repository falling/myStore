package action;

import bean.Usertablebean;
import dao.UserDAO;

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
        if (new UserDAO().register(bean)) {
            return "success";
        }
        return "error";
    }
}
