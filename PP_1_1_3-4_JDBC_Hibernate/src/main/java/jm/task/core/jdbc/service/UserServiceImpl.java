package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public UserServiceImpl() throws SQLException {
    }

    @Transactional
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    @Transactional
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    @Transactional
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    @Transactional
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Transactional
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
