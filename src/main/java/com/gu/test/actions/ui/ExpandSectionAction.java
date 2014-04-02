package com.gu.test.actions.ui;

import com.gu.test.actions.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExpandSectionAction extends UIAction {
    private String expandSectionSelector;


    public ExpandSectionAction()
    {
        this.expandSectionSelector = ".collection__show-more__icon:nth-child(1)";
        //.collection__show-more__icon:nth-child(1)

    }


    @Override
    public void execute(){
        WebDriver driver = driver();
        driver.findElement(By.cssSelector(expandSectionSelector)).click();
    }

    @Override
    public <T> T copyOf() {
        return null;
    }
}
