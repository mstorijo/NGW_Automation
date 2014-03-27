package com.gu.test.actions.ui;

import com.gu.test.actions.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by torilau on 24/03/14.
 */
public class ExpandSectionAction extends UIAction {
    private String expandSectionSelector;


    public ExpandSectionAction()
    {
        this.expandSectionSelector = "(//button[@data-link-name=\"Show more | 0\"])[1]";

    }


    @Override
    public void execute(){
        WebDriver driver = driver();
        driver.findElement(By.xpath(expandSectionSelector));
    }

    @Override
    public <T> T copyOf() {
        return null;
    }
}
