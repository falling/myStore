package action;

import bean.Ordertablebean;
import dao.DAOImpl;

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
        if (action.equals("accept")){
            bean.setState(1);
            new DAOImpl().update(bean);
        }else if(action.equals("finish")){
            bean.setState(2);
            new DAOImpl().update(bean);
        }
        return "success";
    }
}
