package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AS02FirstScriptgGlo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait =new WebDriverWait(driver,20);
		
	
		Properties prop =new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\abhishek.goyal2\\workspace\\GL Assignment apr 18\\globallogicglo.properties");
		
		prop.load(file);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(300);
		
		driver.manage().window().maximize();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='login']")).sendKeys(prop.getProperty("email"));
		
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(prop.getProperty("pwd"));
		
		driver.findElement(By.xpath(".//*[@id='glo-login-form']/div[6]/input")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath(".//*[@id='slideSkip']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='search']")).sendKeys("juhi");
//		Thread.sleep(500);
		
		
		
		//Click sibling with Learning and development

		Thread.sleep(200);

		driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(Keys.ENTER);
//		Thread.sleep(200);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'Juhi')]/parent::div/following-sibling::div[contains(text(),'Learning and Development.')]/preceding-sibling::div/a")));
		driver.findElement(By.xpath(".//a[contains(text(),'Juhi')]/parent::div/following-sibling::div[contains(text(),'Learning and Development.')]/preceding-sibling::div/a")).click();
		
		Thread.sleep(500);

		
		 driver.quit();
	}

}
