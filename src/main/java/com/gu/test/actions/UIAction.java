package com.gu.test.actions;

import hu.meza.aao.Action;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class UIAction implements Action{
    private WebDriver driver;


    @Override
    public void execute() {


    }


    public void useDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    protected WebDriver driver() {
        return driver;
    }

}
