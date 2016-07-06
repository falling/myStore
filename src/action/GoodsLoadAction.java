package action;

import dao.DAOImpl;
import json.JsonRequest;
import service.GeneralService;
import service.GoodsService;
import util.SpringGetBeanUtil;

import java.util.List;

/**
 * 返回json格式的商品信息
 * Created by falling on 2016/6/4.
 */
public class GoodsLoadAction {

    public void execute() throws Exception {
        GoodsService service = (GoodsService) SpringGetBeanUtil.getBean("goodsService");
        List goods = service.loadGoods();
        JsonRequest jsonRequest = new JsonRequest();

        jsonRequest.returnResultWithJson(goods);
    }
}