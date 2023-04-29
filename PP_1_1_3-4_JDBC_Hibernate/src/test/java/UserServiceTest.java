import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static constant.TestConstant.ANY_BYTE;
import static constant.TestConstant.ANY_STRING;

@ContextConfiguration
public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    public UserServiceTest() throws SQLException {
    }

    @Test
//    @Transactional
//    @Rollback
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
//    @Transactional
//    @Rollback
    public void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
//    @Transactional
//    @Rollback
    public void saveUser() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(ANY_STRING, ANY_STRING, ANY_BYTE);

            User user = userService.getAllUsers().get(0);

            if (!ANY_STRING.equals(user.getName())
                    || !ANY_STRING.equals(user.getLastName())
                    || ANY_BYTE != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
//    @Transactional
//    @Rollback
    public void removeUserById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(ANY_STRING, ANY_STRING, ANY_BYTE);
            userService.removeUserById(1L);
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
//    @Transactional
//    @Rollback
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(ANY_STRING, ANY_STRING, ANY_BYTE);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
//    @Transactional
//    @Rollback
    public void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(ANY_STRING, ANY_STRING, ANY_BYTE);
            userService.cleanUsersTable();

            if (userService.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }

}
