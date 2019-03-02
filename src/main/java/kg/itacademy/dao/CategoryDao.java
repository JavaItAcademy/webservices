package kg.itacademy.dao;

import kg.itacademy.model.Category;
import kg.itacademy.model.User;

import java.time.LocalDateTime;
import java.util.*;

public class CategoryDao {
    private static final Map<Integer, Category> categoryMap = new HashMap<>();

    static {
        initCategories();
    }

    static void initCategories () {
        Category cat1 = new Category(1, "Еда",
                UserDao.getUser(1), true );
        Category cat2 = new Category(2, "Транспорт",
                UserDao.getUser(1), true );
        Category cat3 = new Category(3, "Коммунальные услуги",
                UserDao.getUser(2), true );

        categoryMap.put(cat1.getId(), cat1);
        categoryMap.put(cat2.getId(), cat2);
        categoryMap.put(cat3.getId(), cat3);
    }


    public static Category getCategory(Integer id){
        return categoryMap.get(id);
    }


    public static Category addCategory(Category category) {
        categoryMap.put(category.getId(), category);
        return category;
    }

    public static Category updateCategory(Category category) {
        categoryMap.put(category.getId(), category);
        return category;
    }

    public static void deleteCategory(Integer id){
        categoryMap.remove(id);
    }

    public static List<Category> getAllCategories() {
        return new ArrayList<Category>(categoryMap.values());
}
}
