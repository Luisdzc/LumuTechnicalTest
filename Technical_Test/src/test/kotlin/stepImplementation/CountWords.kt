package stepImplementation

import net.thucydides.core.annotations.Step
import org.hamcrest.Matchers
import org.junit.Assert
import pages.WordCountMainPage

open class CountWords {
    private var wordCountPage : WordCountMainPage?=null

    @Step("Open word count page")
    fun openPage(){
        wordCountPage = WordCountMainPage()
    }

    @Step("Write text")
    fun writeText(text : String){
        wordCountPage?.writeText(text)
    }

    @Step("Assert number of words")
    fun expectedWords(numberOfWords: String){
        val words = wordCountPage?.getNumberOfWords()
        Assert.assertThat("The number of word of the text is not the correct",
            words,Matchers.equalTo(numberOfWords))
    }

    fun closeBrowser() {
        wordCountPage?.closeBrowser()
    }


}