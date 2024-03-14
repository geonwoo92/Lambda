package com.erich.api;

import com.erich.api.account.AccountView;
//import board.BoardView;
import com.erich.api.article.ArticleView;
import com.erich.api.enums.Navigation;
import com.erich.api.user.UserView;
import com.erich.api.crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (Navigation.navimain(sc)) {

        }
    }

}

