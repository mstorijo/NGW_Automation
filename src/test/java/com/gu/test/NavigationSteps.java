package com.gu.test;

import com.gu.test.actions.ui.ExpandSectionAction;
import com.gu.test.actions.ui.HideSectionAction;
import com.gu.test.actions.ui.SelectArticleAction;
import com.gu.test.actions.ui.SelectEditionAction;
import com.gu.test.actors.Reader;
import com.gu.test.actors.Readers;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationSteps {

	private Readers readers;
	private Configuration config;

	public NavigationSteps(Readers readers, Configuration config) {
		this.config = config;
		this.readers = readers;
	}

	@When("^(.*) switches to the US edition$")
	public void readerSwitchesToTheUsEdition(String actorLabel) throws Throwable {
		Reader aReader = readers.getReader(actorLabel);
		SelectEditionAction action = new SelectEditionAction("US");
		aReader.execute(action);
	}

	@Then("^the US edition fronts should load$")
	public void theUsEditionFrontsShouldLoad() throws Throwable {
		WebDriver driver = ((Reader) readers.lastActor()).driver();
		Assert.assertTrue(driver.getCurrentUrl().contentEquals(config.baseUrl() + "/us"));
	}

	@When("^(.*) switches to the AU edition$")
	public void readerSwitchesToTheAUEdition(String actorLabel) throws Throwable {
		Reader aReader = readers.getReader(actorLabel);
		SelectEditionAction action = new SelectEditionAction("AU");
		aReader.execute(action);
	}

	@Then("^the AU edition fronts should load$")
	public void theAUEditionFrontsShouldLoad() throws Throwable {
		WebDriver driver = ((Reader) readers.lastActor()).driver();
		Assert.assertTrue(driver.getCurrentUrl().contentEquals(config.baseUrl() + "/au"));
	}

	@When("^(.*) switches to the UK edition$")
	public void readerSwitchesToTheUKEdition(String actorLabel) throws Throwable {
		Reader aReader = readers.getReader(actorLabel);
		SelectEditionAction action = new SelectEditionAction("UK");
		aReader.execute(action);
	}

    @When("^(.*) switches back to the UK edition$")
    public void readerSwitchesBackToTheUKEdition(String actorLabel) throws Throwable {
        readerSwitchesToTheUKEdition(actorLabel);
    }

	@Then("^the UK edition fronts should load$")
	public void theUKEditionFrontsShouldLoad() throws Throwable {
		WebDriver driver = ((Reader) readers.lastActor()).driver();
		Assert.assertTrue(driver.getCurrentUrl().contentEquals(config.baseUrl() + "/uk"));
	}


	@When("^(.*) moves on to the first article$")
	public void readerMovesOnToTheFirstArticle(String actorLabel) throws Throwable {
		Reader aReader = readers.getReader(actorLabel);
		SelectArticleAction action = new SelectArticleAction();
		aReader.execute(action);
	}


	@When("^(.*) expands a section$")
	public void readerExpandsASection(String actorLabel) throws Throwable {
		Reader aReader = readers.getReader(actorLabel);
		ExpandSectionAction action = new ExpandSectionAction();
	    aReader.execute(action);
	}

	@Then("^more headlines in the section should appear$")
	public void moreHeadlinesInSectionShouldAppear() throws Throwable {
        WebDriver driver = ((Reader) readers.lastActor()).driver();
	}

	@When("^^(.*) hides a section$")
	public void readerHidesASection(String actorLabel) throws Throwable {
        Reader aReader = readers.getReader(actorLabel);
        HideSectionAction action = new HideSectionAction();
        aReader.execute(action);
	}

    @Then("^the section should be hidden$")
    public void theSectionShouldBeHidden() throws Throwable {
        WebDriver driver = ((Reader) readers.lastActor()).driver();
        Assert.assertTrue(driver.findElement(By.xpath("//[contains(@class,\"show-more--hidden\"")).isDisplayed());
    }

    @And("^hide should be replaced by show$")
    public void hideShouldBeReplacedByShow() throws Throwable {
        WebDriver driver = ((Reader) readers.lastActor()).driver();
        Assert.assertTrue(driver.findElement(By.xpath("//*[data-link-name='Hide'][1]/text-\"Show")).isDisplayed());

    }
}
