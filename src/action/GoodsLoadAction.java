package action;

import bean.Goodstablebean;
import json.JsonRequest;

/**
 * 返回json格式的商品信息
 * Created by falling on 2016/6/4.
 */
public class GoodsLoadAction {

    private String sql;

    public void execute() throws Exception {
        sql = "where state = 0 and number > 0 ";
        JsonRequest jsonRequest = new JsonRequest();
        jsonRequest.returnAllWithJson(Goodstablebean.class, sql);
    }
}