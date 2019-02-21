package kg.itacademy.dao;

import kg.itacademy.model.User;

import java.time.LocalDateTime;
import java.util.*;

public class UserDao {
    private static final Map<Integer, User> userMap = new HashMap<>();
    static {
        initUsers();
    }

    private static void initUsers() {
        User user1 = new User(1, "Askhat", "123", LocalDateTime.now());
        User user2 = new User(2, "User2", "123", LocalDateTime.now());
        User user3 = new User(3, "User3", "123", LocalDateTime.now());

        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
        userMap.put(user3.getId(), user3);

    }

    public static User getUser(Integer id){
        return userMap.get(id);
    }

    public static User addUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public static User updateUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public static void deleteUser(Integer id){
        userMap.remove(id);
    }

    public static List<User> getAllUsers() {
//        System.out.println("in GetAllUsers");
//        Collection<User> users = userMap.values();
//        List<User> list = new ArrayList<>();
//        list.addAll(users);
//        System.out.println(list);
//        return list;
        return new ArrayList<User>(userMap.values());
    }
}
