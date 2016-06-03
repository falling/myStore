package action;

import bean.Goodstablebean;
import dao.DAOImpl;

/**
 * Created by falling on 2016/6/3.
 */
public class GoodsDeleteAction {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String execute() throws Exception {
        Goodstablebean bean = new Goodstablebean();
        bean.setId(id);
        new DAOImpl().delete(bean);
        return "success";
    }
}
