package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    @Test
    @DisplayName("Хороший тест")
    public void testGithubIssue(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");
        $(".header-search-wrapper").click();
        $(".header-search-wrapper").sendKeys("eroshenkoam/allure-example");
        $(".header-search-wrapper").submit();

        $(linkText("eroshenkoam/allur-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#76")).click();



    }
}
