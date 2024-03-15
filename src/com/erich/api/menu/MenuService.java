package com.erich.api.menu;

import com.erich.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeMenuTable();

    Messenger removeTable();

    List<?> getMenusByCategory(String category);



    Messenger returnMessenger() throws SQLException;



    List<Menu> returnAllMenus(String bu) throws SQLException;
}
