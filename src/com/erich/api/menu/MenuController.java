package com.erich.api.menu;

import com.erich.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {

    private static MenuController instance = new MenuController();

    private MenuServiceImpl menuService;

    public MenuController() {
        menuService = MenuServiceImpl.getInstance();

    }

    public static MenuController getInstance() {
        return instance;
    }

    public Messenger makeMenuTable() {
        return menuService.makeMenuTable();
    }

    public Messenger removeMenuTable() {
        return menuService.removeTable();
    }

    public List<?> getMenusByCategory(String category) {
        return menuService.getMenusByCategory(category);
    }


    public Messenger returnMessenger() throws SQLException {
        return menuService.returnMessenger();
    }


    public List<?> returnAllMenus(String bu) throws SQLException {
        return menuService.returnAllMenus(bu);
    }
}
