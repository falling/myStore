package service;

import bean.Usertablebean;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by falling on 16/7/8.
 */
@Transactional
@Service()
public class UpdateInfoService {
    @Autowired
    private DAOImpl dao;

    public String updateInfo(Usertablebean user) {
        dao.update(user);
        ServletActionContext.getRequest().getSession().setAttribute("user",dao.get(user));
        return "success";
    }
}
