package ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String SEARCH_FIELD_CSS_SELECTOR = "[data-target='qbsearch-input\\.inputButtonText']";
    private static final String SECONDARY_SEARCH_FIELD_CSS_SELECTOR = "input#query-builder-test";
    private static final String NUMBER_RESULTS_TEXT_CSS_SELECTOR = "div[data-testid=search-sub-header] h2#search-results-count";


    public void openMainPage() {
        logger.info("Open https://github.com/");
        Selenide.open("https://github.com/");
    }

    public void clickOnSearchField() {
        logger.info("Clicking of search field");
        SelenideElement minimizedSearchBox = $(By.cssSelector(SEARCH_FIELD_CSS_SELECTOR));
        minimizedSearchBox.click();
    }

    public void enterSearchText(String searchText) {
        logger.info("Entering and submitting search text");
        SelenideElement bigSearchBox = $(By.cssSelector(SECONDARY_SEARCH_FIELD_CSS_SELECTOR));
        bigSearchBox.sendKeys(searchText);
        bigSearchBox.pressEnter();
    }

    public int getSearchResultsNumber() {
        String resultString = Arrays.stream($(By.cssSelector(NUMBER_RESULTS_TEXT_CSS_SELECTOR))
                .getText().split(" ")).findFirst().orElse("0");
        return Integer.parseInt(resultString);
    }


    /**
     * Executes clickOnSearchField() and enterSearchText(String searchText) methods
     */
    public void searchFor(String searchText) {
        clickOnSearchField();
        enterSearchText(searchText);
    }

    public void assertSearchResultsNumber(int expectedSearchResultNumber){
        int actualSearchResultsNumber = getSearchResultsNumber();
        Assertions.assertEquals(expectedSearchResultNumber,actualSearchResultsNumber);
    }

}
