package action;

import bean.GoodsJoinItembean;
import bean.Goodstablebean;
import bean.Itemtablebean;
import dao.DAO;
import dao.DAOImpl;
import json.JsonRequest;
import org.junit.Test;
import service.GeneralService;
import service.OrderService;
import util.SpringGetBeanUtil;

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
        OrderService service = (OrderService) SpringGetBeanUtil.getBean("orderService");
        new JsonRequest().returnResultWithJson(service.getDetails(id));
    }
}
