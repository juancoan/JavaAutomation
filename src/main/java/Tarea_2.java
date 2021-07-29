import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tarea_2 {

    public static void main(String[] args){
        //String pathToDriver = Main.class.getResource("/chromedriver").getPath(); //MacOS, Linux
        String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath(); //Windows
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");

        WebElement searchElement = driver.findElement(By.name("search"));
        searchElement.sendKeys("macbook");

        WebElement searchButton = driver.findElement(By.xpath("(//span[1]/button)[1]"));
        searchButton.click();

        //String myXpath = "(//span[text()='Add to Cart'])[1]";

        WebElement macLink1 = driver.findElement(By.xpath("(//div[contains(@class, 'caption')]/h4/a)[1]"));
        macLink1.click();

        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        WebElement message = driver.findElement(By.xpath("//label[contains(text(), \"Qty\")]"));
        Assert.assertTrue(message.isDisplayed());

        driver.close();
        driver.quit();
    }

}


