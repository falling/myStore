package service;

import bean.Itemtablebean;
import bean.Ordertablebean;
import dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by falling on 16/7/6.
 */
@Transactional
@Service("payService")
public class PayService {
    @Autowired
    private GoodsDAO dao;

    public boolean buy(Ordertablebean bean, Map<Integer, Integer> goodsMap) {
        dao.save(bean);

        for (Map.Entry<Integer, Integer> goodsKV : goodsMap.entrySet()) {
            Itemtablebean itembean = new Itemtablebean();
            itembean.setOrderId(bean.getId());
            itembean.setGoodsId(goodsKV.getKey());
            itembean.setNumber(goodsKV.getValue());
            dao.save(itembean);
            dao.sellOut(itembean);
        }
        return true;
    }
}
