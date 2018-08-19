package dao.userDaoImpl;


import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Usere;
import util.SessionFactoryUtil;

import java.io.Serializable;
import java.util.List;

public class UserImpl implements IuserDap {
    public static SqlSession sqlSession = null;
    IuserDap mapper = null;


    //    打开mybist连接方法
    public void before() {
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(IuserDap.class);
    }

    // 单例测试使用  其他不用
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }


    //登陆方法  有值返回值如果值为空返回空
    @Override
    public Usere login(String userName, String password) {
        Usere nu = null;
        nu = mapper.login(userName, password);
        if (nu != null) {
            return nu;
        }
        return null;
    }

    @Override
    public int add(Usere usere) {
        return 0;
    }

    //    删除方法
    @Override
    public int deleteByCondition(Serializable id) {
        int num = mapper.deleteByCondition(id);
        return num;
    }

    //    修改方法
    @Override
    public int update(Usere usere) {
        int num = mapper.update(usere);
        return num;
    }

    //带条件查询方法
    @Override
    public Usere findByCondition(Serializable id) {
        Usere nu = null;
        nu = mapper.findByCondition(id);
        if (nu != null) {
            return nu;
        }
        return null;
    }

    //    查询全部
    @Override
    public List<Usere> findAll() {
        List<Usere> nu = mapper.findAll();
        return nu;
    }
}
