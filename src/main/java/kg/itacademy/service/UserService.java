package kg.itacademy.service;

import kg.itacademy.dao.UserDao;
import kg.itacademy.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getUsers_JSON() {
        System.out.println("Getting users");
        List<User> users = UserDao.getAllUsers();
        return users;
    }

    // URI:
        // contextPath/servletPath/users/{userId}
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUser(@PathParam("userId") Integer userId){
        return UserDao.getUser(userId);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User addUser(User user) {
        return UserDao.addUser(user);
    }


    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User updateUser(User user) {
        return UserDao.updateUser(user);
    }

    @DELETE
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteUser(@PathParam("userId") Integer userId) {
        UserDao.deleteUser(userId);
    }
}
