package qa.guru.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest extends Selector {

    private static final String REPOSITORY = "ViktoriiaDymkova/Lesson_7_Allure-Reports";
    private static final String ISSUES_NAME = "Issue for example";

    @Test
    public void testGithubIssue() {
        // SelenideLogger.addListener("allure",new AllureSelenide());
        step("Откр глав стр ", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            search.click();
            search.sendKeys(REPOSITORY);
            search.submit();
        });
        step(" Пeреходим по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues ", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует Issues с темой " + ISSUES_NAME, () -> {
            $(withText("Issue for example")).click();
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
