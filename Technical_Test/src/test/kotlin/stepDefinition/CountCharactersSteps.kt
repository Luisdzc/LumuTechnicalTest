package stepDefinition

import cucumber.api.java.After
import cucumber.api.java.en.Then
import net.thucydides.core.annotations.Steps
import stepImplementation.CountCharacters

class CountCharactersSteps {

    @Steps
    val countCharacters : CountCharacters?=null

    @Then("^the right side panel of the page should display \"([^\"]*)\" characters$")
    fun theRightSidePanelOfThePageShouldDisplayCharacters(expectedCharacters: String) {
        countCharacters?.expectedCharacters(expectedCharacters)
    }

    @After
    fun closeBrowser(){
        countCharacters?.closeBrowser()
    }
}