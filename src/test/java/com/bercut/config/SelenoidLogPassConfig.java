package com.bercut.config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/selenoidLoginPassword.properties")
public interface SelenoidLogPassConfig extends Config {

    String login();

    String password();
}
