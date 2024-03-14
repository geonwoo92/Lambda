package com.erich.api.enums;

import com.erich.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    Join("1", (i) -> {
        System.out.println("회원가입");
        UserController.getInstance().save(i);
        return true;
    }),
    Login("2", i -> {
        System.out.println("로그인");
        UserController.getInstance().login(i);
        return true;
    }),
    IdSearch("3", i -> {
        System.out.println("ID검색");
        UserController.getInstance().getOne(i);
        return true;
    }),
    PasswordChange("4", i -> {
        System.out.println("비번 변경");
        UserController.getInstance().updatePassword(i);
        return true;
    }),

    DeleteMember("5", i -> {
        System.out.println("회원탈퇴");
        UserController.getInstance().delete(i);
        return true;
    }),
    NameSerch("6", i -> {
        System.out.println("이름검색");
        UserController.getInstance().findUsersByName(i);
        return true;
    }),
    MemberList("7", i -> {
        System.out.println("회원목록");
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    JobSearch("8", i ->{
        System.out.println("직업검색");
        UserController.getInstance().findUsersByJob(i);
        return true;
    } ),
    CountMember("9", i -> {
        System.out.println("회원수");
        UserController.getInstance().count();
        return true;
    }),
    TableCreate("touch", i -> {
        System.out.println("테이블 생성");
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    TaberDelete("rm", i -> {
        System.out.println("테이블삭제");
        try {
            UserController.getInstance().deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Wrong("",i->{
        System.out.println("잘못된 입력입니다.");
        return true;
    })
    ;


    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }


    public static boolean execute(Scanner scanner) {

        System.out.println("1-회원가입\n" +
                "2-로그인\n" +
                "3-ID 검색\n" +
                "4-비번 번경\n" +
                "5-회원탈퇴\n" +
                "6-이름검색\n" +
                "7-회원목록\n" +
                "8-직업검색\n" +
                "9-회원수\n" +
                "touch-테이블생성\n" +
                "rm-테이블제거\n");
        String msg = scanner.next();
        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny()
                .orElseGet(()->Wrong)
                .predicate
                .test(scanner);
    }
}

