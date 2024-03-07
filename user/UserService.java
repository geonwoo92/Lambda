package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    String addUsers();

    String login(User user);

    Optional<User> findUserById(String username);

    Map<String, ?> findUsersByNameFromMap(String name);

    List<?> findUsersByName(String name);

    String updatePassword(User user);

    List<?> findUsersByJob(String job);

    Map<String, ?> findUsersByJobFromMap(String job);

    Map<String, ?> getUserMap();


    String test();

    List<?> findUsers() throws SQLException;
}
