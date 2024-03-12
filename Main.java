package com.erich.api;

import com.erich.api.account.AccountView;
//import board.BoardView;
import com.erich.api.article.ArticleView;
import com.erich.api.user.UserView;
import com.erich.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "b-Board " +
                    "m-Account " +
                    "c-Crawler " +
                    "a-Article"+
                    "===");
            switch (sc.next()) {
                case "x":
                    return;
                case "u":
                    UserView.main(sc);
                    break;
//                case "2": BoardView.main(); break;
                case "m":
                    AccountView.main(sc);
                    break;
                case "c":
                    CrawlerView.main(sc);
                    break;
                case "a":
                    ArticleView.main(sc);
                    break;
            }
        }
    }

}
