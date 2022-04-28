package qa.guru.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    @Test
    @DisplayName("Мой любимый тест")
    public void testAnnoteted() {
        Allure.parameter("Регион", "Моск обл");
        Allure.parameter("город", "Москва");

    }
}