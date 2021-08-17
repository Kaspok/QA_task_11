package com.bercut.tests;

import com.bercut.helpers.Attach;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.bercut.config.SelenoidLogPass.selenoidLogPassConfig;
import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setup() {
        String login = selenoidLogPassConfig.login(),
                password = selenoidLogPassConfig.password();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
//        if (System.getProperty("selenoidStatus").equals("enabled")) {
//            Configuration.remote = format("https://%s:%s@" + System.getProperty("selenoidUrl"), login, password);
//        }
        Configuration.remote = format("https://%s:%s@" + System.getProperty("selenoidUrl"), login, password);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
