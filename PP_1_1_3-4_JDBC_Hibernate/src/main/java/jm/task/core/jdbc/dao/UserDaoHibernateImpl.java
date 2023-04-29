package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoHibernateImpl extends Util implements UserDao {

    SessionFactory factory = getSessionFactory();

    public UserDaoHibernateImpl() throws SQLException {

    }


    @Override
    public void createUsersTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                    "name VARCHAR(25) NOT NULL," +
                    "lastname VARCHAR(25) NOT NULL," +
                    "age TINYINT NOT NULL);").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Таблица создана");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Таблица удалена");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = factory.getCurrentSession();
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Пользователь сохранён");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("Пользователь удалён");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Query<User> fromUser = session.createQuery("FROM User", User.class);
            userList = fromUser.list();
            for (User user : userList) {
                System.out.println("ID: " + user.getId() + " Name: " + user.getName()
                        + " LastName: " + user.getLastName() + " Age: " + user.getAge());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery("DELETE FROM users");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Все пользователи удалены");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
