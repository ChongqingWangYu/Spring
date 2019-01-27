package test;

import com.wangyu.entity.User;
import com.wangyu.service.IUserService;
import com.wangyu.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IUserServiceTest {
    private static ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
    private static IUserService userServiceImpl=ac.getBean("userService",UserServiceImpl.class);

    @org.junit.Test
    public void saveUser() {
        User user=new User();
        user.setName("qwsheng23er");
        user.setPassword("shenger");
        user.setGroup("管理");
        userServiceImpl.SaveUser(user);
    }

    @org.junit.Test
    public void updateUser() {
        User user=userServiceImpl.findByID(1);
        user.setName("qwshenger");
        user.setPassword("shenger");
        user.setGroup("管理");
        userServiceImpl.UpdateUser(user);
    }

    @org.junit.Test
    public void deleteUser() {
        userServiceImpl.DeleteUser(1);
    }

    @org.junit.Test
    public void findByID() {
        User user=userServiceImpl.findByID(1);
        System.out.println(user.toString());

    }

    @org.junit.Test
    public void findAll() {
        List<User> userList=userServiceImpl.findAll();
        System.out.println(userList);
    }
}