import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestOrder {

    //драйвер для браузера Chrome
    private WebDriver driver = new ChromeDriver();

    //драйвер для браузера Firefox
    //private WebDriver driver = new FirefoxDriver();

    // поля
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String monthYear;
    private  final String day;
    private final String arendaDays;
    private final String color;
    private final String comment;

    //конструктор тестового класса
    public TestOrder(String name, String surname, String address, String metroStation, String phone, String monthYear, String day, String arendaDays, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.monthYear = monthYear;
        this.day = day;
        this.arendaDays = arendaDays;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3} {4} {5} {6} {7} {8} {9}")
    public static Object[][] getData() {
        //тестовые данные
        return new Object[][] {
                {"Анна", "Иванова", "Мира 3", "Белорусская", "89261112233", "март 2023", "19", "сутки", "чёрный жемчуг", "Не звонить"},
                {"Иван", "Корсаков", "Ленина 26", "Курская", "+79261112263", "декабрь 2022", "30", "двое суток", "серая безысходность", "Второй подъезд"},
        };
    }

    @Test
    public void checkOrder() {

        //для браузера Firefox
        //System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\bin\\geckodriver.exe");

        //переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //объект класса главной страницы
        HomePage objHomePage = new HomePage(driver);

        //Клик на кнопку Заказать сверху
        objHomePage.clickInOrderUp();

        //объект класса страницы Для кого заказ
        CustomerPage objCustomerData = new CustomerPage(driver);

        //ожидание, что страница Для кого заказ загрузилась
        objCustomerData.waitForLoadCustomerData();

        //Заполнить форму Для кого заказ и нажать Далее
        objCustomerData.fillCustomerData(name, surname, address,metroStation, phone);
        objCustomerData.fillCustomerNext();

        //объект класса страницы Про аренду
        RentalPage objRentalData = new RentalPage(driver);

        //ожидание, что страница Про аренду загрузилась
        objRentalData.waitForLoadRentalData();

        //Заполнить форму Про аренду и нажать Заказать
        objRentalData.fillRentalData(monthYear, day, arendaDays, color, comment);
        objRentalData.fillRentalOrder();

        //ожидание, что открылось окно подтверждения заказа
        objRentalData.waitForLoadConfirm();

        //Подтвердить заказ
        objRentalData.checkConfirm();

        //ожидание, что открылось окно созданного заказа
        objRentalData.waitForLoadOrder();

        //Проверить, что заказ создался
        objRentalData.checkOrder();
    }

    @Test
    public void checkOrderDown() {

        //для браузера Firefox
        //System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\bin\\geckodriver.exe");

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //объект класса главной страницы
        HomePage objHomePage = new HomePage(driver);

        //Скролл к кнопке Заказать снизу
        objHomePage.scrollForButtonOrderDown();

        //Клик на кнопку Заказать снизу
        objHomePage.clickInOrderDown();

        //объект класса страницы Для кого заказ
        CustomerPage objCustomerData = new CustomerPage(driver);

        //ожидание, что страница Для кого заказ загрузилась
        objCustomerData.waitForLoadCustomerData();

        //Заполнить форму Для кого заказ и нажать Далее
        objCustomerData.fillCustomerData(name, surname, address,metroStation, phone);
        objCustomerData.fillCustomerNext();

        //объект класса страницы Про аренду
        RentalPage objRentalData = new RentalPage(driver);

        //ожидание, что страница Про аренду загрузилась
        objRentalData.waitForLoadRentalData();

        //Заполнить форму Про аренду и нажать Заказать
        objRentalData.fillRentalData(monthYear, day, arendaDays, color, comment);
        objRentalData.fillRentalOrder();

        //ожидание, что открылось окно подтверждения заказа
        objRentalData.waitForLoadConfirm();

        //Подтвердить заказ
        objRentalData.checkConfirm();

        //ожидание, что открылось окно созданного заказа
        objRentalData.waitForLoadOrder();

        //Проверить, что заказ создался
        objRentalData.checkOrder();
    }

    @After
    public void  tearDown() {
        driver.quit();
    }
}