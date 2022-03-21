import beans.User;
import dao.UserDAO;
import db.Connect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao");
        Connect.initConn();
        UserDAO userDAO = context.getBean(UserDAO.class);

        User user1 = new User(20, "Вася", "Пупкин", "Мужской", "+79102832643");
        UserDAO.insert(user1);

        ArrayList users = UserDAO.getAllUsers();

        user1.setAge(25);
        UserDAO.update((User) users.get(1));

        System.out.println(UserDAO.getUser(2));


        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        UserDAO.delete(user1);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}
