package org.example.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefination {
    @Given("User is on NetBanking landing page")
    public void user_is_on_testbanking_application_page() {
        System.out.println("This is Netbanking landing page");

    }
    @When("User login into application with username and password")
    public void user_login_into_application_with_username_and_password() {
        System.out.println("This is  login page scenirio-1");
    }

    @When("User login into application with {string} and password {string}")
    public void user_login_into_application_with_and_password(String userid, String mypassword){
        System.out.println("My userid is " + userid + "and mypassword is " + mypassword);

    }

    @When("^User login in to application with (.+) and password (.+)$")
    public void user_login_in_to_application_with_username_and_password_pass1(String username,String password) {
        System.out.println("My user name is " + username + " and my password is " + password);
    }


    @Then("Home page is populated")
    public void home_page_is_populated() {
        System.out.println("This is home page");}

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("My cards appears here ");
    }

    @And("Cards displayed are {string}")
    public void cards_displayed_are(String card) {
        System.out.println("My cards are displayed " + card);}

}



