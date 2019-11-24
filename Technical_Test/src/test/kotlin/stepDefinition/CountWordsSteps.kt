package stepDefinition

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.thucydides.core.annotations.Steps
import org.junit.After
import stepImplementation.CountWords

class CountWordsSteps {
    @Steps
    val countWords : CountWords?=null

    @Given("^the user is in the word count page$")
    fun theUserIsInTheWordCountPage() {
        countWords?.openPage()
    }
    @When("^the user writes the text \"([^\"]*)\"$")
    fun theUserWritesTheText(text: String) {
        countWords?.writeText(text)
    }

    @Then("^the right side panel of the page should display \"([^\"]*)\" words$")
    fun theRightSidePanelOfThePageShouldDisplayWords(expectedWords: String) {
        countWords?.expectedWords(expectedWords)
    }

    @After
    fun closeBrowser(){
        countWords?.closeBrowser()
    }
}