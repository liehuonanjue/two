package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单例类
 * 目的就是通过接口返回用户一个session
 */


public class SessionFactoryUtil {
    //创建 需要单例的对象
    private static SqlSessionFactory sessionFactory;
//私有化构造

    public SessionFactoryUtil() {
    }

    //    对外部访问接口
    public static synchronized SqlSession getSession() {
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            if (sessionFactory == null) {
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory.openSession();
    }
}
