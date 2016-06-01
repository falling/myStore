package dao;

import bean.Bean;

/**
 * Created by falling on 16/5/28.
 */
public interface DAO {
    /**
     * 保存一条记录
     * @param bean 要增加的记录的bean
     */
    void save(Bean bean);

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
}
