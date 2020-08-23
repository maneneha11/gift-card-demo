package GiftVoucher;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GcToMyself {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\End User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open Demo US voucher page
		driver.get("https://gift-cards.phorest.com/salons/demo-us#");
		driver.manage().window().maximize();

        // Enter user details and Checkout
		driver.findElement(By.xpath("//span[@data-value=\"50\"]")).click();
        driver.findElement(By.xpath("//input[@data-target=\"email.purchaserEmailInput\"]")).sendKeys("maneneha@getnada.com");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserFirstNameInput\"]")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserLastNameInput\"]")).sendKeys("xyz");
        
        driver.findElement(By.xpath("//button[@data-action=\"checkout#checkoutAction\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@data-action=\"confirm#confirmAction\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                
        //Switch to Payment frame and wait for elements to load
        WebElement Iframe = driver.findElement(By.xpath("//iframe[contains(@id, 'hostedform')]"));
        driver.switchTo().frame(Iframe);
        
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("card-name"))));
        
        //Enter payment details and submit
        driver.findElement(By.id("card-name")).sendKeys("abc");
        driver.findElement(By.id("card-zip")).sendKeys("92606");
        driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-expiry")).sendKeys("12/22");
        driver.findElement(By.id("card-security")).sendKeys("999");
        driver.findElement(By.id("submitButton")).click();
        
        
        //driver.close();
        }
	
	
	

}
