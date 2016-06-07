package action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by falling on 2016/6/7.
 */
public class CartAction {
    private int goodsId;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void execute() throws Exception{
        List list = (List) ServletActionContext.getRequest().getSession().getAttribute("list");
        if(list == null){
            list = new ArrayList<>();
            ServletActionContext.getRequest().getSession().setAttribute("list",list);
        }
        list.add(goodsId);
    }
}
