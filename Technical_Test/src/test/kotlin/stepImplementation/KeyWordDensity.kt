package stepImplementation

import net.thucydides.core.annotations.Step
import org.hamcrest.Matchers
import org.junit.Assert
import org.openqa.selenium.support.ui.ExpectedConditions
import pages.WordCountMainPage

open class KeyWordDensity {

    private val wordCountPage = WordCountMainPage()

    @Step("Expected key word density list")
    fun expectedKeyWordDensity(first:String, second:String, third:String){
        val densityList = wordCountPage.getKeyWordDensityList()
        Assert.assertThat("The key word density list has not the correct order:",
            densityList[0],Matchers.containsString(first))
        Assert.assertThat("The key word density list has not the correct order:",
            densityList[1],Matchers.containsString(second))
        Assert.assertThat("The key word density list has not the correct order:",
            densityList[2],Matchers.containsString(third))
    }

    @Step("Expected empty key word density lisy")
    fun keywordDensityIsEmpty() {
        val densityList = wordCountPage.getKeyWordDensityList()
        Assert.assertThat("The key word density list should be empty",
            densityList.isEmpty(), Matchers.equalTo(true))
    }

    fun closeBrowser() {
        wordCountPage.closeBrowser()
    }

}