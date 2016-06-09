package dao;

import bean.Bean;

import java.util.List;

/**
 * Created by falling on 16/5/28.
 */
public interface DAO {
    /**
     * 保存一条记录
     * @param bean
     * @return 返回这条记录的ID
     */
    int save(Bean bean);

    /**
     * 删除一条记录
     * @param bean bean里需要有id的值
     */
    void delete(Bean bean);

    /**
     * 更改一条记录
     * @param bean bean是新的一个对象
     */
    void update(Bean bean);

    /**
     * 根据id获取一个对象
     * @param bean bean里需要有id的值
     * @return
     */
    Object get(Bean bean);

    /**
     * 获取全部的信息
     * @return
     */
    List getAll(Class c);

    /**
     * 根据条件获取list
     * @param c
     * @param sql where开始的sql语句
     * @return
     */
    List getAll(Class c,String sql);

    /**
     * 用于多表查询
     * @param sql
     * @return
     */
    List getAll(String sql);
}
