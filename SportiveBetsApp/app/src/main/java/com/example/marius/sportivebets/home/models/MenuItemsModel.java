package com.example.marius.sportivebets.home.models;


public class MenuItemsModel {

    public String title;
    public int icon;

    public MenuItemsModel(MenuItem menuItem)
    {
        this.title=menuItem.getName();
        this.icon=menuItem.getIcon();
    }
}
