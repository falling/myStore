package dao;

import bean.Goodstablebean;
import bean.Itemtablebean;
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

    public boolean sellOut(Itemtablebean item){
        String sql ="update " + Goodstablebean.class.getSimpleName() + " set number = number - "+ item.getNumber() + " where id = " + item.getGoodsId();
        return getSession().createQuery(sql).executeUpdate() == 1;
    }

}
