package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Ton","Tep",(byte) 25);
        userDaoHibernate.saveUser("Alex","Sob",(byte) 26);
        userDaoHibernate.saveUser("Olga","Gor",(byte) 21);
        userDaoHibernate.saveUser("Pusya","Cat",(byte) 4);

        userDaoHibernate.removeUserById(1);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();

//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Amir", "Blat", (byte) 33);
//        userService.saveUser("name1", "qwe", (byte) 22);
//        userService.saveUser("Olga", "Gordeeva", (byte) 21);
//        userService.saveUser("name3", "zxc", (byte) 11);
//
//        userService.removeUserById(2);
//
//        userService.getAllUsers();
//
//        userService.cleanUsersTable();
//
//        userService.dropUsersTable();
    }
}
