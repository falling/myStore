package dao;

import bean.GoodsJoinItembean;
import bean.OrderJoinUserbean;
import bean.Usertablebean;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Component
public class OrdersDAO extends DAOImpl {

    public List getForList(String action) {
        String sql;
        switch (action) {
            case "userOrder"://用户的订单
                Usertablebean user = (Usertablebean) ServletActionContext.getRequest().getSession().getAttribute("user");
                sql = "and userId = " + user.getId();
                break;
            case "missedOrder"://未接订单
                sql = "and state = 0";
                break;
            case "unfinishedOrder"://未完成的订单
                sql = "and state = 1";
                break;
            case "completedOrder"://完成的订单
                sql = "and state = 2";
                break;
            default:
                sql = "and state = 0";
        }
        String hql = "select new " + OrderJoinUserbean.class.getCanonicalName() +
                "(ord.id,ord.userId,ord.location,ord.time,ord.total,ord.state,ord.remark,user.username,user.tel) "+
                "from bean.Ordertablebean ord,bean.Usertablebean user where ord.userId = user.id ";
        hql = hql +sql;
        return getSession().createQuery(hql).list();
    }

    public List getDetails(int id) {
        String hql = "select new " + GoodsJoinItembean.class.getCanonicalName() +
                " (item.orderId,goods.name,goods.price,goods.type,item.number,goods.imgUrl) " +
                "from bean.Goodstablebean goods,bean.Itemtablebean item where goods.id=item.goodsId and item.orderId = " + id;
        return getSession().createQuery(hql).list();
    }
}
