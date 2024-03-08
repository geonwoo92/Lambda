package common;

import enums.Messenger;
import user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save (T t);
    public abstract List<T> findAll() throws SQLException;
    public abstract Optional<T> findById(long id); // system id
    public abstract String count();
    public abstract Optional<T> getOne(String id); // 외부에서 우리가 쓰는 id

    public abstract Optional<User> findById(Long id);

    public abstract List<?> getUserList();

    public abstract String delete(T t);
    public abstract Boolean existsById(long id);

}
