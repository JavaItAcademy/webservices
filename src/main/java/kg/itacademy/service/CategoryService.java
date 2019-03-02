package kg.itacademy.service;

import kg.itacademy.dao.CategoryDao;
import kg.itacademy.dao.CategoryDao;
import kg.itacademy.dao.UserDao;
import kg.itacademy.model.Category;
import kg.itacademy.model.Category;
import kg.itacademy.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

// URI:
// contextPath/servletPath/categories
@Path("/categories")
public class CategoryService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Category> getCategories_JSON(@HeaderParam("user-key") String login,
                                             @HeaderParam("password-key") String password) {
        if (!UserDao.authorize(login, password)) {
            return  null;
        }
        CategoryDao cat = new CategoryDao();
        List<Category> categories = getCategoriesByUser(login,password);
        return categories;
    }

    // URI:
    // contextPath/servletPath/categories/{categoryId}
    @GET
    @Path("/{categoryId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category getCategory(@PathParam("categoryId") Integer categoryId){
        return CategoryDao.getCategory(categoryId);
    }

    // URI:
    // contextPath/servletPath/categories
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category addCategory(Category category) {
        System.out.println("in add");
        return CategoryDao.addCategory(category);
    }


    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category updateCategory(Category category) {
        return CategoryDao.updateCategory(category);
    }

    @DELETE
    @Path("/{categoryId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCategory(@PathParam("categoryId") Integer categoryId) {
        CategoryDao.deleteCategory(categoryId);
    }

    public List<Category> getCategoriesByUser(String login, String password){
        if (!UserDao.authorize(login, password)){
            return null;
        }
        List<Category> result = new ArrayList<>() ;
        List<Category> categories = CategoryDao.getAllCategories();
        for(Category cat : categories) {
            if (cat.getUser().getName().equals(login)) {
                result.add(cat);
            }
        }
        return result;
    }
}
