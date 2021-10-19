package cucumber.stepdefinitions;

import com.softwareinstitute.andreeaholban.Book;
import com.softwareinstitute.andreeaholban.LibraryItem;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryItemSteps {

    LibraryItem book = null;


    private String actualTitle;
    private String actualAnswer;


    @Given("Harry Potter is the book title")
    public void setTitleToHarryPotter(){
        book = new Book("Harry Potter", "JK Rowling", Boolean.TRUE, "available");
    }

    @Given("Lord of the rings is the book title")
    public void setTitleToLOTR(){
        book = new Book("Lord of the rings", "Tolkien", Boolean.TRUE, "available");
    }


    @When("I check if the book is Harry Potter")
    public void getTitle(){
        actualTitle = book.getTitle();
        if(actualTitle.equals("Harry Potter")){
            actualAnswer = "correct";
        }
        else actualAnswer = "incorrect";

    }

    @Then("The title should be {string}")
    public void checkTitle(String expectedAnswer){
        assertEquals(expectedAnswer, actualAnswer, "Incorrect title");
    }

}
