package GiftVoucher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class GcToSomeone {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\End User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://gift-cards.phorest.com/salons/demo-us#");
		// to maximize browser
		driver.manage().window().maximize();
		
		//Enter User Details and Sumbit
		driver.findElement(By.xpath("//span[@data-value=\"100\"]")).click();
		driver.findElement(By.xpath("//a[@data-target='tabs.sendToOtherTab']")).click();
		
		driver.findElement(By.xpath("//input[@data-target=\"email.purchaserEmailInput\"]")).sendKeys("xyz@gmail.com");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserFirstNameInput\"]")).sendKeys("lmn");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserLastNameInput\"]")).sendKeys("opr");
        driver.findElement(By.xpath("//input[@data-target=\"email.recipientEmailInput\"]")).sendKeys("opr@gmail.com");
        driver.findElement(By.xpath("//textarea[@data-target='email.recipientMessageInput']")).sendKeys("This is Gift");
                    
        driver.findElement(By.xpath("//button[@data-action=\"checkout#checkoutAction\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//button[@data-action=\"confirm#confirmAction\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                
        //Switch to Payment frame and wait for element to load
        WebElement Iframe = driver.findElement(By.xpath("//iframe[contains(@id, 'hostedform')]"));
        driver.switchTo().frame(Iframe);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("card-name"))));
        
        //Enter card details and submit
        driver.findElement(By.id("card-name")).sendKeys("abc");
        driver.findElement(By.id("card-zip")).sendKeys("92606");
        driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-expiry")).sendKeys("12/22");
        driver.findElement(By.id("card-security")).sendKeys("999");
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submitButton"))));
        driver.findElement(By.id("submitButton")).sendKeys(Keys.ENTER);    
	}

}