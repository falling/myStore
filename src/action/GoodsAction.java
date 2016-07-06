package action;

import bean.Goodstablebean;
import dao.DAO;
import dao.DAOImpl;
import org.apache.struts2.ServletActionContext;
import service.GeneralService;
import util.SpringGetBeanUtil;

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
        GeneralService service = (GeneralService) SpringGetBeanUtil.getBean("generalService");
        if (bean == null) {
            List good = service.getAll(Goodstablebean.class);
            ServletActionContext.getRequest().setAttribute("goodsList", good);
            return "load";
        }

        switch (bean.getAction()) {
            case "add":
                service.save(bean);
                break;
            case "delete":
                service.delete(bean);
                break;
            case "update":
                service.update(bean);
                break;
            default:
                return "false";

        }
        return "success";
    }
}
