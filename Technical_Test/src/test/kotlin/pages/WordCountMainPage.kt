package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions

class WordCountMainPage : CorePage() {
    @FindBy(id = "box")
    val textBox : WebElement?=null
    @FindBy(id = "word_count")
    val wordCounter : WebElement?=null
    @FindBy(id = "character_count")
    val characterCounter : WebElement?=null
    @FindBy(id = "kwd-accordion-data")
    val densityWordPanel : WebElement?=null
    @FindBy(xpath = "//a[@class='list-group-item']")
    val densityWordsList : List<WebElement>?=null

    init {
        PageFactory.initElements(super.browser,this)
    }

    fun writeText(text:String){
        wait?.until(ExpectedConditions.visibilityOf(textBox))
        textBox?.sendKeys(text)
    }

    fun getNumberOfWords(): String? {
        wait?.until(ExpectedConditions.visibilityOf(wordCounter))
        return wordCounter?.text
    }

    fun getNumberOfCharacters(): String?{
        wait?.until(ExpectedConditions.visibilityOf(characterCounter))
        return characterCounter?.text
    }

    fun getKeyWordDensityList(): List<String> {
        val wordsList: MutableList<String> = mutableListOf()
        wait?.until(ExpectedConditions.visibilityOf(densityWordPanel))
        if (densityWordsList != null) {
            for(element in densityWordsList.withIndex()){
                wordsList.add(element.index,element.value.text)
            }
        }
        return wordsList
    }
}