package action;

import bean.Goodstablebean;
import dao.DAOImpl;

/**
 * Created by falling on 2016/6/2.
 */
public class GoodsUpdateAction {

    private int id;
    private String goodname;
    private double goodprice;
    private String goodtype;
    private int goodcount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Double goodprice) {
        this.goodprice = goodprice;
    }

    public String getGoodtype() {
        return goodtype;
    }

    public void setGoodtype(String goodtype) {
        this.goodtype = goodtype;
    }

    public int getGoodcount() {
        return goodcount;
    }

    public void setGoodcount(int goodcount) {
        this.goodcount = goodcount;
    }

    public String execute() throws Exception {
        Goodstablebean bean = new Goodstablebean();
        bean.setId(id);
        bean.setName(goodname);
        bean.setCount(goodcount);
        bean.setType(goodtype);
        bean.setPrice(goodprice);
        new DAOImpl().update(bean);
        return "success";
    }
}
