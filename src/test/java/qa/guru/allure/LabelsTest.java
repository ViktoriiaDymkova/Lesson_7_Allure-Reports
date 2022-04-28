package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @IssueShow
    @DisplayName("Мой любимый тест")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testAnnoteted() {
    }

    @Test
    public void testCode(){
        Allure.label("owner","ViktoriiaDymkova");
        Allure.label("severity",SeverityLevel.CRITICAL.value());
        Allure.feature("задачи в репо");
        Allure.story("Просмотр созданных задач в репо");
        Allure.link("Тестинг", "https://github.com");
    }

    @Owner("ViktoriiaDymkova")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("задачи в репо")
    @Story("Просмотр созданных задач в репо")
    public @interface IssueShow{
    }
}