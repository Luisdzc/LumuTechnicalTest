package pages

import controllers.WebDriverController

open class CorePage {
    private val webDriverController = WebDriverController.instanceManager
    val browser = webDriverController.webDriver
    val wait = webDriverController.wait

    fun closeBrowser(){
        browser?.close()
        browser?.quit()
        webDriverController.closeDriverInstance()
    }
}