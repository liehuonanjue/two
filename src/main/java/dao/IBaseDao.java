package dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
    //父类的添加
    int add(T t);

    //父类的删除
    int deleteByCondition(Serializable id);

    //父类的修改
    int update(T t);

    //父类带条件查询
    T findByCondition(Serializable id);

    //父类查询全部
    List<T> findAll();


}
