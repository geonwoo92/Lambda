package user;

import common.AbstractService;
import common.UtilServiceImpl;
import enums.Messenger;


import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<User> implements UserService {


    private static UserServiceImpl instance = new UserServiceImpl();
    Map<String, User> users;

    UserServiceImpl() {
        this.users = new HashMap<>();
        this.reop = UserRepository.getInstance();
    }

    UserRepository reop;


    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger save(User user) {
        users.put(user.getUsername(), user);
        return Messenger.SUCCES;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }


    @Override
    public String count() {
        return null;
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public Optional<User> findUserById(String username) {
        return Optional.of(users.
                values()
                .stream()
                .filter(i -> i.getId().equals(username))
                .collect(Collectors.toList()).get(0));
    }

//    @Override
//    public Optional<User> findById(Long id) {
//        return Optional.of(users
//                .values()
//                .stream()
//                .filter(i -> i.getId().equals(id))
//                .collect(Collectors.toList()).get(0));
//    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }


    @Override
    public List<?> getUserList() {
        return null;
    }

    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "회원삭제";
    }


    @Override
    public Boolean existsById(long id) {
        return null;
    }


    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findUsersByJob(String job) {

        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String test() {
        return null;
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return reop.findUsers();
    }


    @Override
    public String addUsers() {
        IntStream.range(0, 5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, User.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return users.size() + "개 더미값 추가";

    }


}


