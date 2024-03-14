package com.erich.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("1",i->"월요일"),
    Tuesday("2",i->"화요일"),
    Wendesday("3",i->"수요일"),
    Thursday("4",i->"목요일"),
    Friday("5",i->"금요일"),
    Satueday("6",i->"토요일"),
    Sunday("7",i->"일요일"),
    Wrong("",i->"Wrong")
    ;

    private final String name;
    private final Function<String,String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String execute(Scanner sc) {
        System.out.println("1~7 입력:");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findAny()
                .orElseGet(()->Wrong)
                .function
                .apply(s);
    }
}
//findAny() select 의미