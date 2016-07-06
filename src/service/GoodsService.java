package service;

import bean.Goodstablebean;
import dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Transactional
@Service("goodsService")
public class GoodsService {
    @Autowired
    private GoodsDAO dao;

    public List loadGoods() {
        return dao.loadAll(Goodstablebean.class);
    }

}
