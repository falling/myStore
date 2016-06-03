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
     * 登陆
     * @param bean
     * @return
     */
    public Usertablebean login(Usertablebean bean) {
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

    /**
     * 注册
     * @param bean
     * @return
     */
    public boolean register(Usertablebean bean){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from " + bean.getClass().getSimpleName() + " where  username = '" + bean.getUsername() + "'").list();
        if(list.isEmpty()){
            session.save(bean);
            return true;
        }
        return false;

    }

}
