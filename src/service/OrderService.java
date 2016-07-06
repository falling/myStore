package service;

import bean.Bean;
import bean.Ordertablebean;
import dao.OrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Transactional
@Service("orderService")
public class OrderService {
    @Autowired
    private OrdersDAO dao;

    public List getByAction(String action) {
        return dao.getForList(action);
    }

    public void updateOrderByAction(Ordertablebean bean, String action) {
        if (action.equals("accept")) {
            bean.setState(1);
            dao.update(bean);
        } else if (action.equals("finish")) {
            bean.setState(2);
            dao.update(bean);
        }
    }

    public List getDetails(int id) {
        return dao.getDetails(id);
    }
}
