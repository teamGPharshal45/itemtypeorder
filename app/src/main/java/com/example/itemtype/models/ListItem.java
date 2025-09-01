package com.example.itemtype.models;

public abstract class ListItem {

    public static final int TYPE_DATE = 0;
    public static final int TYPE_ORDER = 1;

    abstract public int getType();
}
