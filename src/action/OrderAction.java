package action;

import json.JsonRequest;
import service.OrderService;
import util.SpringGetBeanUtil;

/**
 * order相关的请求
 * Created by falling on 2016/6/9.
 */
public class OrderAction {
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void execute() throws Exception {
        OrderService service = (OrderService) SpringGetBeanUtil.getBean("orderService");
        JsonRequest jsonRequest = new JsonRequest();
        jsonRequest.returnResultWithJson(service.getOrderByAction(action));

    }
}
