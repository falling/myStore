package action;

import service.UserService;
import util.SpringGetBeanUtil;

/**
 * Created by falling on 16/7/8.
 */
public class LoutOutAction {
    public String execute(){
        UserService service = (UserService) SpringGetBeanUtil.getBean("userService");
        service.logout();
        return "success";
    }
}
