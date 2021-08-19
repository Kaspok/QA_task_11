package com.bercut.helpers;

import com.bercut.data.MenuItem;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopBar {

    private SelenideElement topBar = $(".menu-top");

    @Step("Переходим на вкладку `{menuItem}`")
    public void navigateTo(MenuItem menuItem) {
        topBar.$(byText(menuItem.getDisplayName())).click();
    }
}
