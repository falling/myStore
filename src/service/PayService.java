package service;

import bean.Itemtablebean;
import bean.Ordertablebean;
import dao.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Transactional
@Service("payService")
public class PayService {
    @Autowired
    private DAOImpl dao;
    public boolean buy(Ordertablebean bean, List<Integer> goodsList){
        dao.save(bean);
        Itemtablebean itembean = new Itemtablebean();
        itembean.setOrderId(bean.getId());
        for (Integer goodsId : goodsList) {
            itembean.setGoodsId(goodsId);
            dao.save(itembean);
        }
        return true;
    }
}
