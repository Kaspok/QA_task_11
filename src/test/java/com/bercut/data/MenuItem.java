package com.bercut.data;

public enum MenuItem {
    PRODUCTS("продукты"),
    SERVICES("услуги"),
    CLIENTS("клиенты"),
    ABOUT_US("о нас"),
    CAREER("Карьера"),
    SUPPORT("поддержка"),
    PRESS_CENTER("пресс-центр");

    private final String displayName;

    MenuItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


