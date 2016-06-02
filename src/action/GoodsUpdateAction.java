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
    private int goodleft;

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

    public int getGoodleft() {
        return goodleft;
    }

    public void setGoodleft(int goodleft) {
        this.goodleft = goodleft;
    }

    public String execute() throws Exception {
        Goodstablebean bean = new Goodstablebean();
        bean.setId(id);
        bean.setName(goodname);
        bean.setCount(goodleft);
        bean.setType(goodtype);
        bean.setPrice(goodprice);
        bean.setImgUrl("http://i.niupic.com/images/2016/06/02/RbTBna.jpg");
        new DAOImpl().update(bean);
        return "success";
    }
}
