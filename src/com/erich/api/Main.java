package com.erich.api;

import com.erich.api.enums.NavigationOfConsumer;
import com.erich.api.enums.NavigationOfFunction;
import com.erich.api.enums.NavigationOfPredicate;
import com.erich.api.enums.NavigationOfSupply;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        NavigationOfConsumer.navimain(sc);
//        NavigationOfPredicate.navimain(sc);
//        NavigationOfFunction.navimain(sc);
//        NavigationOfSupply.navimain(sc);
        String stringFlag2= NavigationOfFunction.navimain(sc);
        while (stringFlag2.equals("x")) {
        }
//        while (NavigationOfPredicate.navimain(sc)) {
//        }
//        while (NavigationOfConsumer.navimain(sc)) {
//        }
//        while (NavigationOfSupply.navimain(sc)) {
//        }


    }
}
