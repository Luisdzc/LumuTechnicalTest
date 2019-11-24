package stepDefinition

import cucumber.api.PendingException
import cucumber.api.java.en.Then
import net.thucydides.core.annotations.Steps
import org.junit.After
import stepImplementation.KeyWordDensity

class KeyWordDensitySteps {

    @Steps
    val keyWordDensity : KeyWordDensity?=null

    @Then("^the keyword density panel should have in the first three positions the words " +
            "\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    fun theKeywordDensityPanelShouldHaveInTheFirstThreePositionsTheWords
                (first: String, second: String, third: String) {
        keyWordDensity?.expectedKeyWordDensity(first,second,third)
    }

    @Then("^the keyword density panel should be empty$")
    fun theKeywordDensityPanelShouldBeEmpty() {
        keyWordDensity?.keywordDensityIsEmpty()
    }

    @After
    fun closeBrowser(){
        keyWordDensity?.closeBrowser()
    }

}