package org.example.cumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/example/features/Login.feature",
        glue="org.example.stepDefinations",
        monochrome = true
)
public class TestRunner {
}
