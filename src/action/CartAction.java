package action;

import org.apache.struts2.ServletActionContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by falling on 2016/6/7.
 */
public class CartAction {
    private int goodsId;
    private String action;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void execute() throws Exception {
        if (action.equals("add")) {
            addToCart();
        } else if (action.equals("delete")) {
            deleteGoods();
        }
    }

    /**
     * 删除购物车中的商品
     */
    private void deleteGoods() {
        Map goodsMap = (Map) ServletActionContext.getRequest().getSession().getAttribute("goodsMap");
        Integer number = (Integer) goodsMap.get(goodsId);
        if (number != null && number > 0) {
            if (number == 1) {
                goodsMap.remove(goodsId);
            } else {
                number--;
                goodsMap.put(goodsId, number);
            }
        }
    }

    /**
     * 添加到购物车
     */
    private void addToCart() {
        Map goodsMap = (Map) ServletActionContext.getRequest().getSession().getAttribute("goodsMap");
        //如果没有购物信息,创建一个新的map对象。
        if (goodsMap == null) {
            goodsMap = new HashMap();
            ServletActionContext.getRequest().getSession().setAttribute("goodsMap", goodsMap);
        }
        Integer number = (Integer) goodsMap.get(goodsId);
        if (number == null) {
            number = 0;
        }
        number++;
        goodsMap.put(goodsId, number);
    }
}
