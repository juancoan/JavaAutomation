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

        //creando instancia y abriendo pagina
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        //buscando el campo de busqueda
        WebElement searchElement = driver.findElement(By.name("search"));
        searchElement.sendKeys("macbook");

        //click en el boton para ejecutar busqueda
        WebElement searchButton = driver.findElement(By.xpath("(//span[1]/button)[1]"));
        searchButton.click();

        //buscando el primer link de la macbook y click
        WebElement macLink1 = driver.findElement(By.xpath("(//div[contains(@class, 'caption')]/h4/a)[1]"));
        macLink1.click();

        //buscando el boton de add to cart
        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        //luego de darle click en add to car, hago assert de que me sale la palabra "Qty" verificar que si le di click
        WebElement message = driver.findElement(By.xpath("//label[contains(text(), \"Qty\")]"));
        Assert.assertTrue(message.isDisplayed());

        driver.close();
        driver.quit();
    }

}


