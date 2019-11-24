package stepImplementation

import net.thucydides.core.annotations.Step
import org.hamcrest.Matchers
import org.junit.Assert
import pages.WordCountMainPage

open class CountCharacters {

    private var wordCountPage = WordCountMainPage()

    @Step("Assert number of characters")
    fun expectedCharacters(characters: String){
        val numberOfCharacters = wordCountPage.getNumberOfCharacters()
        Assert.assertThat("The number of characters is not the correct for the given text:",
            numberOfCharacters, Matchers.equalTo(characters))
    }

    fun closeBrowser() {
        wordCountPage.closeBrowser()
    }


}