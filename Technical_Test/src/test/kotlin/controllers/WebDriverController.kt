package controllers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.TestConfiguration

/**
 * This class manage the web driver instance for all the UI test cases,
 * Here is defined the web driver wait, and  the control of the initialization and closure of the web driver.
 */
open class WebDriverController {
    private val TIME_OUT = 10L
    private val POLLING = 100L
    var webDriver: WebDriver? = null
    var wait : WebDriverWait? = null
    init {
        initializeWebDriver()
    }
    companion object {
        private var webDriverInstance : WebDriverController?=null
        val instanceManager: WebDriverController
            get() {
                if(webDriverInstance == null){
                    webDriverInstance = WebDriverController()
                }
                return webDriverInstance!!
            }
    }
    fun initializeWebDriver(){
        val properties = TestConfiguration().loadWordCounterProperties()
        System.setProperty(properties.getProperty("webdriverName"),properties.getProperty("webdriverPath"))
        val options = ChromeOptions()
        options.addArguments("--disable-infobars")
        webDriver =  ChromeDriver(options)
        webDriver?.manage()?.window()?.maximize()
        wait = WebDriverWait(webDriver,TIME_OUT,POLLING)
        webDriver?.get(properties.getProperty("webdriver.base.url"))
    }
    fun closeDriverInstance(){
        webDriverInstance = null
    }
}