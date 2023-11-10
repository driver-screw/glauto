package ui;

import org.junit.jupiter.api.Test;

public class FirstPageObjectTest {

    @Test
    public void testRepositoriesSearch() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.searchFor("junit-team/junit5-samples");
        mainPage.assertSearchResultsNumber(3);
    }
}
