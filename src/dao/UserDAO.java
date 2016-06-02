package dao;

import bean.Bean;
import bean.Usertablebean;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by falling on 2016/6/2.
 */
public class UserDAO extends DAOImpl {
    /**
     * 根据username、password获取。
     *
     * @param bean
     * @return
     */
    public Usertablebean getByUsername(Usertablebean bean) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Usertablebean user = null;
        List list = session.createQuery("from " + bean.getClass().getSimpleName() + " where  username = '" + bean.getUsername() + "' and password = '" + bean.getPassword() + "'").list();
        if (!list.isEmpty()) {
            user = (Usertablebean) list.get(0);
        }
        session.getTransaction().commit();
        return user;
    }

}
