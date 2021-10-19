package cucumber.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.assertEquals;


public class SimpleTest {

    private String input;
    private String actualAnswer;


    @Given("Text is Hello world!")
    public void textIsHelloWorld() {
        input = "Hello world!";
    }


    @When("I ask if text is Hello World!")
    public void iAskIfTextIsHelloWorld() {
        if(input.equals("Hello world!")) actualAnswer = "Yes";
        else actualAnswer = "No";
    }



    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }



}
