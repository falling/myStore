package action;

import bean.Ordertablebean;
import dao.DAOImpl;
import service.OrderService;
import util.SpringGetBeanUtil;

/**
 * Created by falling on 2016/6/9.
 */
public class OrderDealAction {
    private Ordertablebean bean;
    private String action;

    public Ordertablebean getBean() {
        return bean;
    }

    public void setBean(Ordertablebean bean) {
        this.bean = bean;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String execute(){
        OrderService service = (OrderService) SpringGetBeanUtil.getBean("orderService");
        service.updateOrderByAction(bean,action);
        return "success";
    }
}
