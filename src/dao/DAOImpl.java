package dao;

import bean.Bean;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 通用DAO实现最基本的增删查改
 * Created by falling on 2016/6/1.
 */
public class DAOImpl implements DAO {
    @Override
    public int save(Bean bean) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int id  = (int) session.save(bean);
        session.getTransaction().commit();
        return id;
    }

    @Override
    public void delete(Bean bean) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object ob = session.get(bean.getClass(), bean.getId());
        session.delete(ob);
        session.getTransaction().commit();
    }

    @Override
    public void update(Bean bean) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        int PKValue = -1;

        //获取PK的值。
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Id.class) != null) {
                try {
                    PKValue = (int) method.invoke(bean);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        session.beginTransaction();
        Object oldBean = session.get(bean.getClass(), PKValue);

        if (oldBean != null) {
            Field[] fields = oldBean.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(bean) != null) {
                        field.set(oldBean, field.get(bean));
                    }
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            session.update(oldBean);
            session.getTransaction().commit();
        }

    }

    @Override
    public Object get(Bean bean) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object object = session.get(bean.getClass(), bean.getId());
        session.getTransaction().commit();
        return object;
    }

    @Override
    public List getAll(Class c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from " + c.getSimpleName() + " where state = 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List getAll(Class c,String sql) {
        if(sql ==null){
            return getAll(c);
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from " + c.getSimpleName() + " " + sql).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List getAll(String sql){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery(sql).list();
        session.getTransaction().commit();
        return list;
    }
}
