package service;

import bean.Bean;
import dao.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by falling on 16/7/6.
 */
@Transactional
@Service("generalService")
public class GeneralService {
    @Autowired
    private DAOImpl dao;

    public int save(Bean bean){
        return dao.save(bean);
    }

    public void delete(Bean bean){
        dao.delete(bean);
    }

    public void update(Bean bean){
        dao.update(bean);
    }

    public Object get(Bean bean){
        return dao.get(bean);
    }

    public List getAll(Class c){
        return dao.getAll(c);
    }

}
