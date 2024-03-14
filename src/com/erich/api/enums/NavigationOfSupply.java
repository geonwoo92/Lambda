package com.erich.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigationOfSupply {
//    EXIT("e",),
//    USER("u", ),
//    ARTICLE("a", ),
//    ACCOUNT("ac",),
//    CRAWLER("c", ),
//    //BOARD("b", i->""),
//    NAVIGATION_ERROR("er",)


    ;

    private final String menu;
    private final Supplier<Scanner> supplier;

    NavigationOfSupply(String menu, Supplier<Scanner> supplier) {
        this.menu = menu;
        this.supplier = supplier;
    }

    public static boolean navimain(Scanner sc) {
        return false;
    }
}
