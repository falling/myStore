package action;

import bean.Goodstablebean;
import dao.DAO;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by falling on 2016/6/2.
 */
public class GoodsAction {

    private Goodstablebean bean;

    public Goodstablebean getBean() {
        return bean;
    }

    public void setBean(Goodstablebean bean) {
        this.bean = bean;
    }

    public String execute() throws Exception {
        if (bean == null) {
            List good = new DAOImpl().getAll(Goodstablebean.class);
            ServletActionContext.getRequest().setAttribute("goodsList", good);
            return "load";
        }

        switch (bean.getAction()) {
            case "add":
                new DAOImpl().save(bean);
                break;
            case "delete":
                new DAOImpl().delete(bean);
                break;
            case "update":
                new DAOImpl().update(bean);
                break;
            default:
                return "false";

        }
        return "success";
    }
}
