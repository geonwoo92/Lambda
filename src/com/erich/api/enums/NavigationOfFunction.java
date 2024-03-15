package com.erich.api.enums;

import com.erich.api.account.AccountView;
import com.erich.api.article.Article;
import com.erich.api.article.ArticleView;
import com.erich.api.crawler.CrawlerView;
import com.erich.api.menu.Menu;
import com.erich.api.menu.MenuController;
import com.erich.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    EXIT("x",i->"x"),
    USER("u", i-> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ARTICLE("ar", i-> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ACCOUNT("ac", i-> {AccountView.main(i);
        return "";
    }),
    CRAWLER("c", i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),


    //BOARD("b", i->""),
    //NAVIGATION_ERROR("error",i->"er")

    ;

    private final String name;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String navimain(Scanner sc) throws SQLException {

        System.out.println(MenuController.getInstance().returnAllMenus("navigate"));

        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        System.out.println("선택한 메뉴 : "+ msg);

        return Stream.of(values())
                .filter(i->i.name.equals(msg))
                .findAny()
                .orElseGet(()->EXIT)
                .function
                .apply(sc);

    }
}
