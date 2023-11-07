package ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class FirstUiTest {

    private static final String SEARCH_FIELD_CSS_SELECTOR = "[data-target='qbsearch-input\\.inputButtonText']";
    private static final String SECONDARY_SEARCH_FIELD_CSS_SELECTOR = "input#query-builder-test";
    private static final String NUMBER_RESULTS_TEXT_CSS_SELECTOR = "div[data-testid=search-sub-header] h2#search-results-count";

    @Test
    public void testSearchForExistingRepo() {
        Selenide.open("https://github.com/");
        SelenideElement minimizedSearchBox = $(By.cssSelector(SEARCH_FIELD_CSS_SELECTOR));
        minimizedSearchBox.click();
        SelenideElement bigSearchBox = $(By.cssSelector(SECONDARY_SEARCH_FIELD_CSS_SELECTOR));

        bigSearchBox.sendKeys("junit-team/junit5-samples");
        bigSearchBox.pressEnter();

        String s = Arrays.stream($(By.cssSelector(NUMBER_RESULTS_TEXT_CSS_SELECTOR))
                .getText().split(" ")).findFirst().orElse("0");
        int resultNumber = Integer.parseInt(s);
        Assertions.assertEquals(3, resultNumber);

    }
}
