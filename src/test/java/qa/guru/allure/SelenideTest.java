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

public class SelenideTest extends Selector {
    @Test
    @DisplayName("Первый тест")
    public void testGithubIssue(){
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com");
        search.click();
        search.sendKeys("ViktoriiaDymkova/Lesson_7_Allure-Reports");
        search.submit();

        $(linkText("ViktoriiaDymkova/Lesson_7_Allure-Reports")).click();
        $(partialLinkText("Issues")).click();
        $(withText("Issue for example")).click();
    }
}
