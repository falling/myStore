package dao;

import bean.Bean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 通用DAO实现最基本的增删查改
 * Created by falling on 2016/6/1.
 */
@Component("dao")
public class DAOImpl implements DAO {

    @Autowired
    protected SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public int save(Bean bean) {
        return (int) getSession().save(bean);
    }

    @Override
    public void delete(Bean bean) {
        Session session = getSession();
        Object ob = session.get(bean.getClass(), bean.getId());
        session.delete(ob);
    }

    @Override
    public void update(Bean bean) {
        Session session = getSession();
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
        }

    }

    @Override
    public Object get(Bean bean) {
        return getSession().get(bean.getClass(), bean.getId());
    }

    @Override
    public Object getOne(Class c) {
        return null;
    }

    @Override
    public List getAll(Class c) {
        return getSession().createQuery("from " + c.getSimpleName() + " where state = 0").list();
    }

}
