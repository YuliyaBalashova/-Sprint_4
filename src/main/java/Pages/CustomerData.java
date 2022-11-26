package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Класс страницы с формой Для кого заказ
public class CustomerData {

    private WebDriver driver;

    // поле Имя
    private By nameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");

    // поле Фамилия
    private By surnameField = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");

    // поле Адрес: куда привезти заказ
    private By addressField = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");

    // поле Станция метро
    private By metroStationField = By.xpath(".//input[@class='select-search__input']");

    // список станций метро
    private By metroStationList = By.xpath(".//div[@class='select-search__select']");

    // поле Телефон
    private By phoneField = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");

    // кнопка Далее
    private By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public CustomerData (WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadCustomerData() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonNext));
    }

    // методы для заполнения формы Для кого самокат
    public void fillCustomerData(String name, String surname, String address, String metroStation, String phone) {
        driver.findElement(nameField).sendKeys(name);                    //заполнить поле имя
        driver.findElement(surnameField).sendKeys(surname);             //заполнить поле фамилия
        driver.findElement(addressField).sendKeys(address);            //заполнить поле адрес
        driver.findElement(metroStationField).sendKeys(metroStation);       //заполнить на поле станция метро
        driver.findElement(metroStationList).click();                      //кликнуть на выпадающий список со станцией метро
        driver.findElement(phoneField).sendKeys(phone);                   //заполнить поле телефон
    }

    //метод клика по кнопке Далее
    public void fillCustomerNext() {
        driver.findElement(buttonNext).click();
    }
}