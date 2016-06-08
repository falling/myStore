package action;

import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

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

    public void execute() throws Exception{
        if(action.equals("add")) {
            addToCart();
        }else if(action.equals("delete")){
            deleteGoods();
        }
    }

    /**
     * 删除购物车中的商品
     */
    private void deleteGoods() {
        List list = (List) ServletActionContext.getRequest().getSession().getAttribute("goodsList");
        list.remove(new Integer(goodsId));
    }

    /**
     * 添加到购物车
     */
    private void addToCart() {
        List list = (List) ServletActionContext.getRequest().getSession().getAttribute("goodsList");
        if(list == null){
            list = new ArrayList<>();
            ServletActionContext.getRequest().getSession().setAttribute("goodsList",list);
        }
        list.add(goodsId);
    }
}
