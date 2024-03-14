package com.erich.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationOfConsumer {

    EXIT("e", (sc) -> {}),
    USER("u",(sc) -> {} ),
    ARTICLE("a",(sc) -> {}),
    ACCOUNT("ac",(sc) -> {}),
    CRAWLER("c",(sc) -> {} ),
    //BOARD("b", i->""),
    NAVIGATION_ERROR("er",(sc) -> {})
    ;


    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public static boolean navimain(Scanner sc) {
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");


        return false;
    }
}
