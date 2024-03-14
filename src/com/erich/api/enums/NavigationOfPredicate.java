package com.erich.api.enums;

import java.util.Scanner;
import java.util.function.Predicate;

public enum NavigationOfPredicate {
//    EXIT("e",),
//    USER("u", ),
//    ARTICLE("a", ),
//    ACCOUNT("ac",),
//    CRAWLER("c", ),
//    //BOARD("b", i->""),
//    NAVIGATION_ERROR("er",)

    ;

    private final String name;
    private final Predicate<Scanner> predicate;

    NavigationOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }


    public static boolean navimain(Scanner sc) {
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");

        return true;


    }
}
