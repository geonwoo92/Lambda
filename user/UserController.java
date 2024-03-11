package user;

import common.Member;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    UserServiceImpl userService;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }

    public Map<String, ?> getUserMap() {
        System.out.println("전체 목록 출력");
        return userService.getUserMap();
    }

    public String addUsers() {
        return userService.addUsers();
    }

    public Messenger save(Scanner scanner) {
        System.out.println("ID, " + "비밀번호, " + "비밀번호 확인, " + "이름, " + "주민번호 " + "전화번호, " + "주소, " + "직업을 입력해주세요");
        return userService.save(User.builder().username(scanner.next()).password(scanner.next()).verify_password(scanner.next()).name(scanner.next()).build());
    }

    public String login(Scanner scanner) {
        System.out.println("로그인할 ID 입력 : ");
        return userService.login(User.builder().username(scanner.next()).password(scanner.next()).build());
    }

    public Optional<User> findUserById(Scanner scanner) {
        System.out.println("검색할 ID 입력 : ");

        return userService.findUserById(scanner.next());
    }

    public String updatePassword(Scanner scanner) {
        System.out.println("수정할 ID 입력 : ");
        System.out.println("수정할 비번 입력 : ");
        return userService.updatePassword(User.builder().phone(scanner.next()).username(scanner.next()).password(scanner.next()).build());
    }


    public String delete(Scanner scanner) {
        System.out.println("삭제할 ID 입력 : ");

        return userService.delete(User.builder().username(scanner.next()).build());

    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public Boolean existsById(Scanner scanner) {
        return userService.existsById(Long.parseLong(scanner.next()));
    }

    public List<?> findUsersByName(Scanner scanner) {
        System.out.println("이름으로 검색");
        return userService.findUsersByName(scanner.next());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner scanner) {
        return userService.findUsersByNameFromMap(scanner.next());
    }

    public List<?> findUsersByJob(Scanner scanner) {
        System.out.println("직업으로 검색");
        return userService.findUsersByJob(scanner.next());
    }

    public Map<String, ?> findUsersByJobFromMap(Scanner scanner) {
        return userService.findUsersByJobFromMap(scanner.next());
    }

    public Optional<User> getOne(Scanner scanner) {
        return userService.getOne(scanner.next());
    }

    public String count() {
        System.out.println("회원수");
        return userService.count();
    }

    public String addUser() {
        return userService.addUsers();
    }


    public String test() {
        return userService.test();
    }

    public List<?> findUsers() throws SQLException {
        return userService.findUsers();
    }

    public Messenger createTable() throws SQLException {
        return userService.createTable();
    }

    public String deleteTable() throws SQLException {
        return userService.deleteTable();
    }


}
