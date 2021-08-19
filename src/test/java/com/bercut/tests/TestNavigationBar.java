package com.bercut.tests;

import com.bercut.data.MenuItem;
import com.bercut.helpers.TopBar;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Тестирования панели навигации")
public class TestNavigationBar extends TestBase {

    TopBar topBar = new TopBar();

    @Test
    @Order(1)
    @DisplayName("Проверка наличии вкладок на начальной странице")
    void testHomePage() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
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
    @Order(2)
    @DisplayName("Проверяем описание вкладки 'продукты'")
    void testTabsProduct() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.PRODUCTS);
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
    @Order(3)
    @DisplayName("Проверяем описание вкладки 'услуги'")
    void testTabsServices() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.SERVICES);
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'услуги' и " +
                "текст: комплексные услуги и решения с дополнительными сервисами «под ключ»", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".services-top").shouldHave(text("услуги"));
            $(".services-top").$(".description").shouldHave(text("комплексные услуги и решения " +
                    "с дополнительными сервисами «под ключ»"));
        });
    }

    @Test
    @Order(4)
    @DisplayName("Проверяем описание вкладки 'клиенты'")
    void testTabsClients() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.CLIENTS);
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'клиенты' и " +
                "текст: операторы связи и их партнеры, использующие продукты Bercut", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".clients-top").shouldHave(text("клиенты"));
            $(".clients-top").$(".description").shouldHave(text("операторы связи и их партнеры, использующие " +
                    "продукты Bercut"));
        });
    }

    @Test
    @Order(5)
    @DisplayName("Проверяем описание вкладки 'о нас'")
    void testTabsAboutUs() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.ABOUT_US);
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'о нас'", () -> {
            $(".about-top").shouldHave(text("о нас"));
        });
    }

    @Test
    @Order(6)
    @DisplayName("Проверяем описание вкладки 'карьера'")
    void testTabsCareer() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.CAREER);
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'карьера'", () -> {
            $(".job-top").shouldHave(text("карьера"));
        });
    }

    @Test
    @Order(7)
    @DisplayName("Проверяем переход по вкладке 'поддержка'")
    void testTabsSupport() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.SUPPORT);
        switchTo().window(1);
        step("Проверяем, что на новой открытой вкладке присутствует текст 'Добро пожаловать в службу поддержки" +
                " продуктов Bercut', возвращаемся на начальную страницу", () -> {
            $(".title", 1).shouldHave(text("добро пожаловать в службу поддержки продуктов Bercut"));
            switchTo().window(0);
        });
    }

    @Test
    @Order(8)
    @DisplayName("Проверяем описание вкладки 'пресс-центр'")
    void testTabsPressCenter() {
        step("Открываем начальную страницу", () -> {
            open("https://www.bercut.com/");
        });
        topBar.navigateTo(MenuItem.PRESS_CENTER);
        step("Проверяем, что в описании вкладки содержится наименование вкладки 'пресс-центр' и " +
                "текст: операторы связи и их партнеры, использующие продукты Bercut", () -> {
            SelenideLogger.addListener("allure", new AllureSelenide());
            $(".news-top").shouldHave(text("пресс-центр"));
            $(".news-top").$(".description").shouldHave(text("для связи с пресс-центром пишите на " +
                    "pr@bercut.com"));
        });
    }

}
