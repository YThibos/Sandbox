package be.thibos.login.dao;

import be.thibos.login.entities.User;

public interface UserDAO {

    User findById(long id);

    void insertUser(User user);
}
