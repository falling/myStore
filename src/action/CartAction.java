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
            List list = (List) ServletActionContext.getRequest().getSession().getAttribute("list");
            list.remove(new Integer(goodsId));
        }
    }

    /**
     * 添加到购物车
     */
    private void addToCart() {
        List list = (List) ServletActionContext.getRequest().getSession().getAttribute("list");
        if(list == null){
            list = new ArrayList<>();
            ServletActionContext.getRequest().getSession().setAttribute("list",list);
        }
        list.add(goodsId);
    }
}
