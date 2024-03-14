package com.erich.api.enums;

import com.erich.api.account.AccountView;
import com.erich.api.article.ArticleView;
import com.erich.api.crawler.CrawlerView;
import com.erich.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate22 {
//    EXIT("x", (sc) -> {
//        return false;
//    }),
//    USER("u", (sc) -> {
//        try {
//            UserView.main(sc);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return true;
//    }),
//    ARTICLE("a", (sc) -> {
//        try {
//            ArticleView.main(sc);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }),
//    ACCOUNT("ac", (sc) -> {
//        AccountView.main(sc);
//        return true;
//    }),
//    CRAWLER("c", (sc) -> {
//        try {
//            CrawlerView.main(sc);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return true;
//    }),
//    BOARD("b", (sc) -> {
////        BoardView.main();
//        return true;
//    }),
//    NAVIGATION_ERROR("er", (sc) -> {
//        System.out.println("에러");
//        return true;
//    });
//
//
//    private final String menu;
//    private final Predicate<Scanner> predicate;
//
//    NavigationOfPredicate22(String menu, Predicate<Scanner> predicate) {
//        this.menu = menu;
//        this.predicate = predicate;
//    }
//
//    public static boolean navimain(Scanner sc) {
//        System.out.println(
//                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
//        String msg = sc.next();
//        return Stream.of(NavigationOfPredicate22.values())
//                .filter(i -> i.menu.equals(msg))
//                .findAny().orElse(NAVIGATION_ERROR)
//                .predicate.test(sc);
//    }

}
