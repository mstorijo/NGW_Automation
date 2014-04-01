package com.gu.test.actions.ui;


import com.gu.test.actions.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HideSectionAction extends UIAction{


    public HideSectionAction()
    {

    }


    public void execute() {
        WebDriver driver = driver();
        driver.findElement(By.xpath("//*[text()='Hide']")).click();

    }

    @Override
    public <T> T copyOf() {
        return null;
    }
}
