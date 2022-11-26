package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Класс главной страницы
public class HomePage {

    private WebDriver driver;

    // все элементы с вопросами
    private By allImportantQuestions = By.xpath(".//div[contains(@id,'accordion__heading-')]");

    // 1 элемент с вопросом: Сколько это стоит? И как оплатить?
    private By priceQuestion = By.xpath(".//div[@class='accordion']/div[1]/div[1]/div");

    // 1 элемент с ответом на вопрос: Сколько это стоит? И как оплатить?
    private By priceAnswer = By.xpath(".//div[@class='accordion']/div[1]/div[2]/p");

    // 2 элемент с вопросом: Хочу сразу несколько самокатов! Так можно?
    private By moreScootersQuestion = By.xpath(".//div[@class='accordion']/div[2]/div[1]/div");

    // 2 элемент с ответом на вопрос: Хочу сразу несколько самокатов! Так можно?
    private By moreScootersAnswer = By.xpath(".//div[@class='accordion']/div[2]/div[2]/p");

    // 3 элемент с вопросом: Как рассчитывается время аренды?
    private By timeQuestion = By.xpath(".//div[@class='accordion']/div[3]/div[1]/div");

    // 3 элемент с ответом на вопрос: Как рассчитывается время аренды?
    private By timeAnswer = By.xpath(".//div[@class='accordion']/div[3]/div[2]/p");

    // 4 элемент с вопросом: Можно ли заказать самокат прямо на сегодня?
    private By todayQuestion = By.xpath(".//div[@class='accordion']/div[4]/div[1]/div");

    // 4 элемент с ответом на вопрос: Можно ли заказать самокат прямо на сегодня?
    private By todayAnswer = By.xpath(".//div[@class='accordion']/div[4]/div[2]/p");

    // 5 элемент с вопросом: Можно ли продлить заказ или вернуть самокат раньше?
    private By timeChangeQuestion = By.xpath(".//div[@class='accordion']/div[5]/div[1]/div");

    // 5 элемент с ответом на вопрос: Можно ли продлить заказ или вернуть самокат раньше?
    private By timeChangeAnswer = By.xpath(".//div[@class='accordion']/div[5]/div[2]/p");

    // 6 элемент с вопросом: Вы привозите зарядку вместе с самокатом?
    private By butteryQuestion = By.xpath(".//div[@class='accordion']/div[6]/div[1]/div");

    // 6 элемент с ответом на вопрос: Вы привозите зарядку вместе с самокатом?
    private By butteryAnswer = By.xpath(".//div[@class='accordion']/div[6]/div[2]/p");

    // 7 элемент с вопросом: Можно ли отменить заказ?
    private By annulQuestion = By.xpath(".//div[@class='accordion']/div[7]/div[1]/div");

    // 7 элемент с ответом на вопрос: Можно ли отменить заказ?
    private By annulAnswer = By.xpath(".//div[@class='accordion']/div[7]/div[2]/p");

    // 8 элемент с вопросом: Я жизу за МКАДом, привезёте?
    private By liveQuestion = By.xpath(".//div[@class='accordion']/div[8]/div[1]/div");

    // 8 элемент с ответом на вопрос: Я жизу за МКАДом, привезёте?
    private By liveAnswer = By.xpath(".//div[@class='accordion']/div[8]/div[2]/p");


    // кнопка Заказать сверху
    private By orderUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // кнопка Заказать снизу
    private By orderDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // клик на кнопку Заказать сверху
    public void clickInOrderUp() {
        driver.findElement(orderUp).click();
    }

    // метод для скролла к кнопке Заказать снизу
    public void scrollForButtonOrderDown() {
        WebElement element = driver.findElement(orderDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // клик на кнопку Заказать снизу
    public void clickInOrderDown() {
        driver.findElement(orderDown).click();
    }

    // метод для скролла к списку вопросов
    public void scrollForLoadImportantQuestions() {
        WebElement element = driver.findElement(allImportantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод для скролла к последнему вопросу
    public void scrollForLiveQuestion() {
        WebElement element = driver.findElement(liveQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод для проверки 1 элемента c вопросом
    public boolean checkPriceQuestion() {
        driver.findElement(priceQuestion).click();
        return driver.findElement(priceAnswer).isEnabled();
    }

    // метод для проверки 2 элемента с вопросом
    public boolean checkMoreScootersQuestion() {
        driver.findElement(moreScootersQuestion).click();
        return driver.findElement(moreScootersAnswer).isEnabled();
    }

    // метод для проверки 3 элемента с вопросом
    public boolean checkTimeQuestion() {
        driver.findElement(timeQuestion).click();
        return driver.findElement(timeAnswer).isEnabled();
    }

    // метод для проверки 4 элемента с вопросом
    public boolean checkTodayQuestion() {
        driver.findElement(todayQuestion).click();
        return driver.findElement(todayAnswer).isEnabled();
    }

    // метод для проверки 5 элемента с вопросом
    public boolean checkTimeChangeQuestion() {
        driver.findElement(timeChangeQuestion).click();
        return driver.findElement(timeChangeAnswer).isEnabled();
    }

    // метод для проверки 6 элемента с вопросом
    public boolean checkButteryQuestion() {
        driver.findElement(butteryQuestion).click();
        return driver.findElement(butteryAnswer).isEnabled();
    }

    // метод для проверки 7 элемента с вопросом
    public boolean checkAnnulQuestion() {
        driver.findElement(annulQuestion).click();
        return driver.findElement(annulAnswer).isEnabled();
    }

    // метод для проверки 8 элемента с вопросом
    public boolean checkLiveQuestion() {
        driver.findElement(liveQuestion).click();
        return driver.findElement(liveAnswer).isEnabled();
    }

}