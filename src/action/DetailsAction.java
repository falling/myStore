package action;

import bean.GoodsJoinItembean;
import bean.Goodstablebean;
import bean.Itemtablebean;
import dao.DAO;
import dao.DAOImpl;
import json.JsonRequest;
import org.junit.Test;

import java.util.List;

/**
 * 订单详情
 * Created by falling on 2016/6/9.
 */
public class DetailsAction {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void execute() throws Exception {
        DAOImpl dao = new DAOImpl();
        String sql = "select new " + GoodsJoinItembean.class.getCanonicalName() +
                " (item.orderId,goods.name,goods.price,goods.type,item.number,goods.imgUrl) " +
                "from bean.Goodstablebean goods,bean.Itemtablebean item where goods.id=item.goodsId and item.orderId = " +id;
        List list = dao.getAll(sql);
        new JsonRequest().returnResultWithJson(list);
    }
}
