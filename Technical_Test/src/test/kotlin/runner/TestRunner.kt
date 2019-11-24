package runner

import common.FEATURES
import common.STEPS
import cucumber.api.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(plugin = ["pretty"],features = [FEATURES], glue = [STEPS])
class TestRunner {
}