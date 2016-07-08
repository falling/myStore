package action;

import bean.Ordertablebean;
import bean.Usertablebean;
import org.apache.struts2.ServletActionContext;
import service.PayService;
import util.SpringGetBeanUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by falling on 2016/6/8.
 */
public class PayAction {
    private Ordertablebean bean;

    public Ordertablebean getBean() {
        return bean;
    }

    public void setBean(Ordertablebean bean) {
        this.bean = bean;
    }

    public String execute() throws Exception {
        PayService payService = (PayService) SpringGetBeanUtil.getBean("payService");

        Usertablebean user = (Usertablebean) ServletActionContext.getRequest().getSession().getAttribute("user");
        Map<Integer,Integer> goodsMap = (Map) ServletActionContext.getRequest().getSession().getAttribute("goodsMap");

        bean.setUserId(user.getId());
        payService.buy(bean,goodsMap);
        ServletActionContext.getRequest().getSession().setAttribute("goodsMap",null);
        return "success";
    }
}
