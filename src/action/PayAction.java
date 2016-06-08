package action;

import bean.Itemtablebean;
import bean.Ordertablebean;
import bean.Usertablebean;
import dao.DAO;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;

import java.util.List;

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
        Usertablebean user = (Usertablebean) ServletActionContext.getRequest().getSession().getAttribute("user");
        bean.setUserId(user.getId());
        DAO dao = new DAOImpl();
        //保存订单信息。
        dao.save(bean);
        //保存订单详情信息。
        saveItemTable(dao);
        //清除订单信息
        ServletActionContext.getRequest().getSession().setAttribute("goodsList",null);
        return "success";
    }

    //保存订单详情信息。
    private void saveItemTable(DAO dao) {
        Itemtablebean itembean = new Itemtablebean();
        List<Integer> goodsList = (List<Integer>) ServletActionContext.getRequest().getSession().getAttribute("goodsList");
        if (goodsList != null) {
            itembean.setOrderId(bean.getId());
            for (Integer goodsId : goodsList) {
                itembean.setGoodsId(goodsId);
                dao.save(itembean);
            }
        }
    }
}
