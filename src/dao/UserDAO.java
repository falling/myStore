package dao;

import bean.Usertablebean;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by falling on 2016/6/2.
 */

@Component
public class UserDAO extends DAOImpl {
    /**
     * 登陆
     *
     * @param bean
     * @return
     */
    public Usertablebean login(Usertablebean bean) {
        Session session = getSession();
        String sql = "from " + bean.getClass().getSimpleName() + " where  username = '" + bean.getUsername() + "' and password = '" + bean.getPassword() + "'";
        return (Usertablebean) session.createQuery(sql).uniqueResult();
    }

    /**
     * 注册
     *
     * @param bean
     * @return
     */
    public boolean register(Usertablebean bean){
        Session session = getSession();
        List list = getSession().createQuery(String.format("from %s where  username = '%s'", bean.getClass().getSimpleName(), bean.getUsername())).list();
        if (list.isEmpty()) {
            session.save(bean);
            return true;
        }
        return false;
    }

}
