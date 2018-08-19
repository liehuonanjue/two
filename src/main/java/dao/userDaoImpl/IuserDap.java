package dao.userDaoImpl;

import dao.IBaseDao;
import org.apache.ibatis.annotations.Param;
import pojo.Usere;

public interface IuserDap extends IBaseDao<Usere> {
//     声明参数方便mybist xml 使用 参数
    Usere login(@Param("name") String userName,@Param("pwd") String password);

}
