package action;

import bean.Usertablebean;
import json.JsonRequest;
import org.apache.struts2.ServletActionContext;
import service.UpdateInfoService;
import util.SpringGetBeanUtil;

import java.io.IOException;

/**
 * Created by falling on 16/7/8.
 */
public class UserInfoUpdateAction {
    private String oldPassword;
    private Usertablebean user;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Usertablebean getUser() {
        return user;
    }

    public void setUser(Usertablebean user) {
        this.user = user;
    }

    public void execute() throws IOException {
        UpdateInfoService service = (UpdateInfoService) SpringGetBeanUtil.getBean("updateInfoService");
        Usertablebean oldUser = (Usertablebean) ServletActionContext.getRequest().getSession().getAttribute("user");
        user.setId(oldUser.getId());
        String result;
        if(oldPassword==null){
            result = service.updateInfo(user);
        }else{
            if(oldUser.getPassword().equals(oldPassword)) {
                result = service.updateInfo(user);
            }else{
                result = "密码错误";
            }
        }
        new JsonRequest().returnResultWithJson(result);

    }
}
