package com.example.itemtype.models;

public class SubMenu {

    private int MenuImg;
    private String MenuName;


    public SubMenu(int menuImg, String menuName) {
        MenuImg = menuImg;
        MenuName = menuName;
    }

    public int getMenuImg() {
        return MenuImg;
    }

    public void setMenuImg(int menuImg) {
        MenuImg = menuImg;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }
}
