package action;

import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by falling on 2016/6/7.
 */
public class BuyAction {
    private List goodList;

    public List getGoodList() {
        return goodList;
    }

    public void setGoodList(List goodList) {
        this.goodList = goodList;
    }

    public String execute() throws Exception{
        for (int i = 0; i < goodList.size(); i++) {
            System.out.println(goodList.get(i));
        }
        ServletActionContext.getRequest().setAttribute("list", goodList);
        return "success";
    }
}
