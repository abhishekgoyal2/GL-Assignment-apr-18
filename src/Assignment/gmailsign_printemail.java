package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailsign_printemail {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait =new WebDriverWait(driver,20);
		
	
		Properties prop =new Properties();
		
		FileInputStream file = new FileInputStream("C:/Users/abhishek.goyal2/workspace/GL Assignment apr 18/src/Assignment/gmailloginproperty.properties");
		
		prop.load(file);
		
		
//		url : https://accounts.google.com/SignUp?hl=en-GB
//			Locators :
//			Sign in-.//*[@id='link-signin']
//
//			User another account :.//*[@id='identifierLink']/div[2]/p
//			Email or phone :.//*[@id='identifierId']
//			password :.//*[@id='password']/div[1]/div/div[1]/input
		//next @password .//*[@id='passwordNext']/content/span
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(300);
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='link-signin']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(prop.getProperty("email"));

		Thread.sleep(300);
			driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
			Thread.sleep(200);
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")));
			driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(prop.getProperty("pwd"));

			
			driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".WaidBe")));
			driver.findElement(By.cssSelector(".WaidBe")).click();
		

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id=':2p']/div[5]")));
	
			driver.findElement(By.xpath(".//*[@id=':2p']/div[5]")).click();
			
		Thread.sleep(200);
		 List<WebElement> Socialmails=driver.findElements(By.xpath(".//*[@class='xS' ]/div/div/span[@class='bog']"));
		
	
	
		 int count=Socialmails.size();
		 System.out.println(count);
		 
	 for (int i=1;i<=10;i++)
		 {
				String emailtest=Socialmails.get(i).getText();
				 
				System.out.println(" printing subject" + " " + i  + "of email " +  emailtest);
				 
		
		 }
		
				 
		
		 driver.quit();
	
	}

}
