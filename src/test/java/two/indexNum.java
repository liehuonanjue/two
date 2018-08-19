package two;


import dao.userDaoImpl.UserImpl;
import pojo.Usere;

import java.util.List;
import java.util.Scanner;

public class indexNum {
    static Scanner input = new Scanner(System.in);
    static UserImpl userimpl = new UserImpl();

    public static void main(String[] args) {
        userimpl.before();
        call();  //登陆方法
    }

    //    登陆
    private static void call() {
        System.out.println("请输入用户名");
        String name = input.next();
        System.out.println("请输入密码");
        String pwd = input.next();
        Usere usere = userimpl.login(name, pwd);
        if (usere != null) {
            swit();
        } else {
            System.out.println("不存在这个用户");
        }
    }

    //switch 选择
    private static void swit() {
        System.out.println("请选择");
        System.out.println("1是根据id查询 2是删除 3是修改 4是查询全部");
        switch (input.nextInt()) {
            case 1:
                FindByid();
                break;
            case 2:
                delete();
                break;
            case 3:
                update();
                break;
            case 4:
                all();
                break;
            default:
                userimpl.sqlSession.close();
                break;
        }
    }

    //    查询全部
    private static void all() {
        List<Usere> usere = userimpl.findAll();
        for (Usere usere1 : usere) {
            System.out.println("id" + usere1.getUwerId() + "用户名" + usere1.getUserName() + "密码" + usere1.getUserpwd());
        }
        swit();
    }


    //    删除
    private static void delete() {
        System.out.println("请选择删除id");
        int num = input.nextInt();
        int sum = userimpl.deleteByCondition(num);
        if (sum > 0) {
            userimpl.sqlSession.commit();
            System.out.println("删除成功");
            swit();
        } else {
            userimpl.sqlSession.rollback();
            System.out.println("修改失败");
            swit();
        }
    }

    // 修改
    private static void update() {
        System.out.println("选择id修改用户名");
        int num = input.nextInt();
        Usere usere = new Usere();
        usere.setUwerId(num);
        System.out.println("请输入修改后用户名");
        usere.setUserName(input.next());
        int sum = userimpl.update(usere);
        if (sum > 0) {
            userimpl.sqlSession.commit();
            System.out.println("修改成功");
            swit();
        } else {
            userimpl.sqlSession.rollback();
            System.out.println("修改失败");
            swit();
        }
    }

    //根据id查询
    private static void FindByid() {
        System.out.println("根據id 查詢name");
        int num = input.nextInt();
        Usere usere = userimpl.findByCondition(num);
        System.out.println("id" + usere.getUwerId() + "用户名" + usere.getUserName() + "密码" + usere.getUserpwd());
        swit();
    }
}
