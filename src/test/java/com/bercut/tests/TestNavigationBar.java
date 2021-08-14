package com.bercut.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestNavigationBar extends TestBase {

    @Test
    @DisplayName("Проверка наличии вкладок на начальной странице")
    void testHomePage() {
        step("Проверяем, что на панели навигации присутствуют: продукты, услуги, клиенты, о нас, карьера," +
                "поддержка, пресс-центр", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".menu-top").shouldHave(text("продукты"));
            $(".menu-top").shouldHave(text("услуги"));
            $(".menu-top").shouldHave(text("клиенты"));
            $(".menu-top").shouldHave(text("о нас"));
            $(".menu-top").shouldHave(text("карьера"));
            $(".menu-top").shouldHave(text("поддержка"));
            $(".menu-top").shouldHave(text("пресс-центр"));
        });
    }

    @Test
    @DisplayName("Проверяем описание вкладки 'продукты'")
    void testTabsProduct() {
        step("Открываем вкладку 'продукты'", () -> {
            $(".menu-top").$(byText("продукты")).click();
        });
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'продукты' и " +
                "текст: программные комплексы для оказания услуг связи абонентам и обеспечения бизнес-процессов " +
                "операторов связи и их партнеров", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".solutions-top").shouldHave(text("продукты"));
            $(".solutions-top").$(".description").shouldHave(text("программные комплексы для оказания услуг " +
                    "связи абонентам и обеспечения бизнес-процессов операторов связи и их партнеров"));
        });
    }

    @Test
    @DisplayName("Проверяем описание вкладки 'услуги'")
    void testTabsServices() {
        step("Открываем вкладку 'услуги'", () -> {
            $(".menu-top").$(byText("услуги")).click();
        });
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'услуги' и " +
                "текст: комплексные услуги и решения с дополнительными сервисами «под ключ»", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".services-top").shouldHave(text("услуги"));
            $(".services-top").$(".description").shouldHave(text("комплексные услуги и решения " +
                    "с дополнительными сервисами «под ключ»"));
            System.out.println();
        });
    }

    @Test
    @DisplayName("Проверяем описание вкладки 'клиенты'")
    void testTabsClients() {
        step("Открываем вкладку 'клиенты'", () -> {
            $(".menu-top").$(byText("клиенты")).click();
        });
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'клиенты' и " +
                "текст: операторы связи и их партнеры, использующие продукты Bercut", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".clients-top").shouldHave(text("клиенты"));
            $(".clients-top").$(".description").shouldHave(text("операторы связи и их партнеры, использующие " +
                    "продукты Bercut"));
        });
    }

    @Test
    @DisplayName("Проверяем описание вкладки 'о нас'")
    void testTabsAboutUs() {
        step("Открываем вкладку 'о нас'", () -> {
            $(".menu-top").$(byText("о нас")).click();
        });
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'о нас'", () -> {
            $(".about-top").shouldHave(text("о нас"));
        });
    }
}
