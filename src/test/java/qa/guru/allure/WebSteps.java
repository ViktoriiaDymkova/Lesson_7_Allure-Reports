package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps extends Selector {

    @Step("Откр глав стр ")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo} ")
    public void searchForRepository(String repo) {
        search.click();
        search.setValue(repo);
        search.submit();
    }
    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Кликаем на таб Issues {repo}")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }
    @Step("Проверяем, что существует Issues с темой {name} ")
    public void shouldSeeIssueWithName(String name){
        $(withText(name)).should(Condition.visible);
        attachScreenShot();
    }

    @Attachment(value = "Мой люб скриншот", type = "image/png", fileExtension = "png")
public byte[] attachScreenShot (){
return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
}
}
