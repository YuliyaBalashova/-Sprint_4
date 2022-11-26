package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс страницы с формой Про аренду
public class RentalData {

    private WebDriver driver;

    //поле Когда привезти
    private By calendarField = By.cssSelector(".react-datepicker-wrapper");

    //элемент с названием месяца и годом в календаре
    private By calendarMonthYear = By.xpath(".//div[@class='react-datepicker__current-month']");

    //стрелка переключения месяцев в календаре
    private By calendarNextMonth = By.xpath(".//button[text()='Next Month']");

    //поле Срок аренды
    private By arendaField = By.cssSelector(".Dropdown-placeholder");

    //выпадающий список дней аренды
    private By arendaOneDay = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
    private By arendaTwoDay = By.xpath(".//div[@class='Dropdown-menu']/div[2]");
    private By arendaThreeDay = By.xpath(".//div[@class='Dropdown-menu']/div[3]");
    private By arendaFourDay = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
    private By arendaFiveDay = By.xpath(".//div[@class='Dropdown-menu']/div[5]");
    private By arendaSixDay = By.xpath(".//div[@class='Dropdown-menu']/div[6]");
    private By arendaSevenDay = By.xpath(".//div[@class='Dropdown-menu']/div[7]");

    //чек-бокс Цвет самоката Черный жемчуг
    private By colorBlackBox = By.id("black");

    //чек-бокс Цвет самоката Серая безысходность
    private By colorGreyBox = By.id("grey");

    //поле Комментарий для курьера
    private By commentField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");

    // кнопка Заказать
    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // кнопка ДА в окне подтверждения заказа
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //кнопка Посмотреть статус в окне c номером созданного заказа
    private By buttonStatusOrder = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");

    //Текст в окне заказа: Заказ оформлен
    private By textOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'and text()='Заказ оформлен']");

    public RentalData(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadRentalData() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonOrder));
    }

    // методы для заполнения формы Про аренду

    //метод заполнения поля Когда привезти самокат
    public void fillRentalCalendar(String monthYear, String day) {

        driver.findElement(calendarField).click();                             //кликнуть на поле календарь
        String elementMonth = driver.findElement(calendarMonthYear).getText();
        while (!elementMonth.equals(monthYear)) {
            driver.findElement(calendarNextMonth).click();                   //клик на стрелку следующего месяца
            elementMonth = driver.findElement(calendarMonthYear).getText(); //присвоить переменной новое значение
        }
        driver.findElement(By.xpath(String.format(".//div[(not(contains(@class,'react-datepicker__day--outside-month')) and text()='%s')]", day))).click();  //выбрать день (class задан с учетом того, что число д.б. настоящего месяца)
    }

    //метод заполнения поля Срок аренды
    public void fillRentalDays(String arendaDays) {

        driver.findElement(arendaField).click();                  //кликнуть на поле срок аренды
        if (arendaDays.equals("сутки")) {
            driver.findElement(arendaOneDay).click();            //кликнуть на элемент списка дней аренды: сутки
        }
        if (arendaDays.equals("двое суток")) {
            driver.findElement(arendaTwoDay).click();
        }
        if (arendaDays.equals("трое суток")) {
            driver.findElement(arendaThreeDay).click();
        }
        if (arendaDays.equals("четверо суток")) {
            driver.findElement(arendaFourDay).click();
        }
        if (arendaDays.equals("пятеро суток")) {
            driver.findElement(arendaFiveDay).click();
        }
        if (arendaDays.equals("шестеро суток")) {
            driver.findElement(arendaSixDay).click();
        }
        if (arendaDays.equals("семеро суток")) {
            driver.findElement(arendaSevenDay).click();
        }
    }

    //метод заполнения поля Цвет самоката
    public void fillRentalColor(String color) {
        if (color.equals("чёрный жемчуг")) {
            driver.findElement(colorBlackBox).click();           //кликнуть на чек-бокс с цветом Черный жемчуг
        } if (color.equals("серая безысходность")) {
            driver.findElement(colorGreyBox).click();            //кликнуть на чек-бокс с цветом Серая безысходность
        }
    }

    //метод заполнения поля Комментарий
    public void fillRentalComment(String comment) {
        driver.findElement(commentField).click();                 //кликнуть на поле комментарий
        driver.findElement(commentField).sendKeys(comment);       //заполнить поле комментарий
    }

    //кликнуть на кнопку Заказать
    public void fillRentalOrder() {
        driver.findElement(buttonOrder).click();
    }


    //метод ожидания, что открылось окно подтверждения заказа
    public void waitForLoadConfirm() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(buttonYes));
    }

    //метод нажатия кнопки подтверждения заказа
    public void checkConfirm() {
        driver.findElement(buttonYes).click();
    }

    //метод ожидания, что открылось окно созданного заказа
    public void waitForLoadOrder() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonStatusOrder));
    }

    //проверка успешно созданного заказа
    public void checkOrder() {
        driver.findElement(textOrder).isEnabled();
    }

}
