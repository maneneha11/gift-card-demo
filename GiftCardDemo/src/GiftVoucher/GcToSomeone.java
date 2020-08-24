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

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\PATH\\TO\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://gift-cards.phorest.com/salons/demo-us#");
		// to maximize browser
		driver.manage().window().maximize();
		
		//Enter User Details and Submit
		driver.findElement(By.xpath("//span[@data-value=\"100\"]")).click();
		driver.findElement(By.xpath("//a[@data-target='tabs.sendToOtherTab']")).click();
		
		driver.findElement(By.xpath("//input[@data-target=\"email.purchaserEmailInput\"]")).sendKeys("testmail@testdomain.com");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserFirstNameInput\"]")).sendKeys("Demo");
        driver.findElement(By.xpath("//input[@data-target=\"name.purchaserLastNameInput\"]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@data-target=\"email.recipientEmailInput\"]")).sendKeys("newmail@testdomain.com");
        driver.findElement(By.xpath("//textarea[@data-target='email.recipientMessageInput']")).sendKeys("This is a Gift");
                    
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
        driver.findElement(By.id("card-name")).sendKeys("Demo");
        driver.findElement(By.id("card-zip")).sendKeys("92606");
        driver.findElement(By.id("card-number")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("card-expiry")).sendKeys("12/22");
        driver.findElement(By.id("card-security")).sendKeys("999");
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submitButton"))));
        driver.findElement(By.id("submitButton")).sendKeys(Keys.ENTER); 
        
        //verify if the payment was successful
        Thread.sleep(5000);
        String result = driver.findElement(By.xpath("//p[@class=\"text-xl font-medium mb-8\"]")).getText();
        
        if (result.equals("Payment accepted, thank you!")) {
        	System.out.println("Payment successfull");
        }
        else
        	System.out.println("There was an error processing the payment. Please check the card details and try again");
        
        driver.close();
	}

}
