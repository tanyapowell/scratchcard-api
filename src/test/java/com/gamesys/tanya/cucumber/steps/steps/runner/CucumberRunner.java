package com.gamesys.tanya.cucumber.steps.steps.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/cucumber"},
        glue={"steps"}
    )
public class CucumberRunner {

}
