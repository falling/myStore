package dao;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Component
public class GoodsDAO extends DAOImpl {
    public List loadAll(Class c) {
        String sql = "from "+c.getSimpleName()+" where state = 0 and number > 0 ";
        return getSession().createQuery(sql).list();
    }

}
