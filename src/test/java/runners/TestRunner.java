package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Users/sdurmus/IdeaProjec/API_Cucumber/src/test/resources/features", // Feature dosyalarının yolu
        glue = "steps",
        plugin = {"pretty",
                "html:target/cucumber-reports.html"
               }
)


public class TestRunner {


}

