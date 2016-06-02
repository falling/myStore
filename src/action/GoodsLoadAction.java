package action;

import bean.Goodstablebean;
import bean.Usertablebean;
import dao.DAO;
import dao.DAOImpl;
import dao.UserDAO;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * Created by falling on 2016/6/1.
 */
public class GoodsLoadAction {
    public String execute() throws Exception {
        DAO dao = new DAOImpl();
        List goods = dao.getAll(Goodstablebean.class);
        ServletActionContext.getRequest().setAttribute("goodsList", goods);
        return "success";
    }
}
