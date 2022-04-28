package qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUES_NUMBER = 68;

    @Test
    public void testGithubIssue() {
        // SelenideLogger.addListener("allure",new AllureSelenide());
        step("Откр глав стр ", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-wrapper").click();
            $(".header-search-wrapper").sendKeys(REPOSITORY);
            $(".header-search-wrapper").submit();
        });
        step(" ПЕреходим по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues ", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует Issues с номером " + ISSUES_NUMBER, () -> {
            $(withText("#76")).click();
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
