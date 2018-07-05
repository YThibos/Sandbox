package be.thibos.login.dao;

import be.thibos.login.entities.User;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserDAOImplTest {

    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAOImpl();
    }

    @Test
    public void findById() throws Exception {
        User inputUser = new User(1L, "Yannick");
        userDAO.insertUser(inputUser);
        User user = userDAO.findById(1L);

        assertThat(user.getId(), is(1L));
        assertThat(user.getName(), is("Yannick"));
        assertThat(user, is(equalTo(inputUser)));
    }

}