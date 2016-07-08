package service;

import bean.Usertablebean;
import dao.UserDAO;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by falling on 16/7/5.
 */
@Transactional
@Service("userService")
public class UserService {
    @Autowired
    private UserDAO dao;

    public Usertablebean login(Usertablebean bean) {
        return dao.login(bean);
    }

    public boolean register(Usertablebean bean) {
        return dao.register(bean);
    }

    public void logout(){
        ServletActionContext.getRequest().getSession().setAttribute("user", null);
        ServletActionContext.getRequest().getSession().setAttribute("goodsMap", null);
    }
}
