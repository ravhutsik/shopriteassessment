package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectsFactory.HomePageObjects;
import utils.driverFactory;

import java.io.IOException;

public class SearchProducts {
    private HomePageObjects takealotelements = new HomePageObjects(driverFactory.getDriver());

    @Given("^i have launched the TakeALot website and page title$")
    public void iHaveLaunchedTheTakeALotWebsiteAndPageTitle() throws IOException {
        takealotelements.VerifyHomeTitle();
    }

    @When("^i enter the name of the product and click the search icon button\\.$")
    public void iEnterTheNameOfTheProductAndClickTheSearchIconButton() throws IOException {
        takealotelements.SearchProductName();
        takealotelements.ClickSearchButton();
    }

    @And("^i Click on the searched product to verify the product price and description$")
    public void iClickOnTheSearchedProducttoVerifyTheProductPriceAndDescription() throws IOException {
        takealotelements.ClickSearchedProduct();
        takealotelements.ValidateProductPriceAndDescription();
    }

    @Then("^I scroll down and click on the product information and verify information is displayed\\.$")
    public void iScrollDownAndClickOnTheProductInformationAndVerifyInformationIsDisplayed() throws IOException {
        takealotelements.ValidateProductPriceAndDescription();
    }

    @Then("^i validate verify that product information is displayed$")
    public void iValidateVerifyThatProductInformationIsDisplayed() throws IOException {
        takealotelements.VerifyProductInformationIsDisplayed();

    }
}
