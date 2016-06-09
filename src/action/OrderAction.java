package action;

import bean.Ordertablebean;
import bean.Usertablebean;
import json.JsonRequest;
import org.apache.struts2.ServletActionContext;
/**
 * order相关的请求
 * Created by falling on 2016/6/9.
 */
public class OrderAction {
    private String action;
    private String sql;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void execute() throws Exception {
        switch (action) {
            case "userOrder"://用户的订单
                Usertablebean user = (Usertablebean) ServletActionContext.getRequest().getSession().getAttribute("user");
                sql = "where userId = " + user.getId();
                break;
            case "unfinishedOrder"://未完成的订单
                sql = "where state = 1";
                break;
            case "completedOrder"://完成的订单
                sql = "where state = 2";
                break;

        }
        JsonRequest jsonRequest = new JsonRequest();
        jsonRequest.returnAllWithJson(Ordertablebean.class, sql);
    }
}
