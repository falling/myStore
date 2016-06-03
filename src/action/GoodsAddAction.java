package action;

import bean.Goodstablebean;
import dao.DAOImpl;

/**
 * Created by falling on 2016/6/2.
 */
public class GoodsAddAction {

    private String goodname;
    private double goodprice;
    private String goodtype;
    private int goodcount;


    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(double goodprice) {
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
        bean.setName(goodname);
        bean.setCount(goodcount);
        bean.setType(goodtype);
        bean.setPrice(goodprice);
        new DAOImpl().save(bean);
        return "success";
    }
}
