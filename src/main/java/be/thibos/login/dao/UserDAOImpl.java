package be.thibos.login.dao;

import be.thibos.login.entities.User;
import org.hibernate.jpa.HibernateEntityManagerFactory;

import java.util.HashMap;
import java.util.Map;

public class UserDAOImpl implements UserDAO {

    private Map<Long, User> users = new HashMap<>();

    public UserDAOImpl(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public User findById(long id) {
        return users.get(id);
    }

    @Override
    public void insertUser(User user) {
        users.put(user.getId(), user);
    }
}
