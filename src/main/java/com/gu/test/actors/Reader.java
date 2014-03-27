package com.gu.test.actors;

import com.gu.test.actions.UIAction;
import hu.meza.aao.Action;
import hu.meza.aao.Actor;
import hu.meza.tools.HttpClientWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by torilau on 20/03/14.
 */
public class Reader extends Actor {

    private HttpClientWrapper httpClient;
    private WebDriver driver;

    public Reader (){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

    }


    public void killBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void execute(Action action) {

        if (action instanceof UIAction) {
            ((UIAction) action).useDriver(driver);
        }


        super.execute(action);
    }

    public WebDriver driver() {

        return driver;
    }
}
