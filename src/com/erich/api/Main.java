package com.erich.api;

import com.erich.api.enums.*;
import com.erich.api.menu.Menu;
import com.erich.api.menu.MenuController;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

//        Messenger msg = MenuController.getInstance().returnMessenger();
//        Menu oneMenu = MenuController.getInstance().returnOneMenu();
//        List<?> allMenu = MenuController.getInstance().returnAllMenus();






//        MenuController.getInstance().makeMenuTable();


       Scanner sc = new Scanner(System.in);
//        NavigationOfConsumer.navimain(sc);
//        NavigationOfPredicate.navimain(sc);
//        NavigationOfFunction.navimain(sc);
//        NavigationOfSupply.navimain(sc);
        String stringFlag2= NavigationOfFunction.navimain(sc);
        while (!stringFlag2.equals("x")) ;

//        while (NavigationOfPredicate.navimain(sc)) {
//        }
//        while (NavigationOfConsumer.navimain(sc)) {
//        }
//        while (NavigationOfSupply.navimain(sc)) {
//        }


    }
}
