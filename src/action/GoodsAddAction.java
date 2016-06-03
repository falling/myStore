package action;

import bean.Goodstablebean;
import dao.DAOImpl;

/**
 * Created by falling on 2016/6/2.
 */
public class GoodsAddAction {

    private Goodstablebean bean = new Goodstablebean();

    public Goodstablebean getBean() {
        return bean;
    }

    public void setBean(Goodstablebean bean) {
        this.bean = bean;
    }

    public String execute() throws Exception {
        new DAOImpl().save(bean);
        return "success";
    }
}
