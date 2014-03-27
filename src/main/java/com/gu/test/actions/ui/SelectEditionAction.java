package com.gu.test.actions.ui;

import com.gu.test.actions.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by torilau on 20/03/14.
 */
public class SelectEditionAction extends UIAction {

    private final String edition;

    public SelectEditionAction(String edition) {

        this.edition = edition;
    }

    @Override
    public void execute() {
       WebDriver driver = driver();
      // driver.findElement(By.cssSelector("[data-edition=\""+ edition + "\"]")).click();
        driver.findElement(By.cssSelector("[data-edition= \"" + edition + "\"]")).click();

    }


    @Override
    public <T> T copyOf() {
        return null;
    }
}
