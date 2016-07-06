package service;

import bean.Usertablebean;
import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by falling on 16/7/5.
 */
@Transactional
@Service("LoginService")
public class UserService {
    @Autowired
    private UserDAO dao;

    public Usertablebean login(Usertablebean bean) {
        return dao.login(bean);
    }

    public boolean register(Usertablebean bean) {
        return dao.register(bean);
    }

}
