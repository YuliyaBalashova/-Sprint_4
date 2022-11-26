import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;

public class TestQuestions {

    //драйвер для браузера Chrome
    private WebDriver driver = new ChromeDriver();

    @Test
    public void checkImportantQuestions() {

        //переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //объект класса главной страницы
        HomePage objHomePage = new HomePage(driver);

        //скролл к вопросам
        objHomePage.scrollForLoadImportantQuestions();

        //проверка 1 элемента с вопросом
        boolean checkPrice = objHomePage.checkPriceQuestion();
        assertTrue(checkPrice);

        //проверка 2 элемента с вопросом
        boolean checkMoreScooters = objHomePage.checkMoreScootersQuestion();
        assertTrue(checkMoreScooters);

        //проверка 3 элемента с вопросом
        boolean checkTime = objHomePage.checkTimeQuestion();
        assertTrue(checkTime);

        //проверка 4 элемента с вопросом
        boolean checkToday = objHomePage.checkTodayQuestion();
        assertTrue(checkToday);

        //проверка 5 элемента с вопросом
        boolean checkTimeChange = objHomePage.checkTimeChangeQuestion();
        assertTrue(checkTimeChange);

        //проверка 6 элемента с вопросом
        boolean checkButtery = objHomePage.checkButteryQuestion();
        assertTrue(checkButtery);

        //проверка 7 элемента с вопросом
        boolean checkAnnul = objHomePage.checkAnnulQuestion();
        assertTrue(checkAnnul);

        //скролл к 8 вопросу (т.к. вне зоны видимости после клика на 7 вопрос)
        objHomePage.scrollForLiveQuestion();

        //проверка 8 элемента с вопросом
        boolean checkRoad = objHomePage.checkLiveQuestion();
        assertTrue(checkRoad);

        driver.quit();
    }
}