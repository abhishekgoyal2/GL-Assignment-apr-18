package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AS02SecondScriptGlo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		try{
			WebDriver driver = new FirefoxDriver();
			
			WebDriverWait wait =new WebDriverWait(driver,20);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			driver.findElement(By.cssSelector(".profile")).click();
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='profileTabs']/li[4]/a")));
			driver.findElement(By.xpath(".//*[@id='profileTabs']/li[4]/a")).click();
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".career-title.pull-left.pm-skill-title")));
	WebElement primsecskill=driver.findElement(By.cssSelector(".career-title.pull-left.pm-skill-title"));
	String prim=primsecskill.getText();	
	System.out.println(prim);

	if (prim.equalsIgnoreCase("PRIMARY AND SECONDARY SKILLS"))
	{
		System.out.println("text is matching");

	}

	else 
	{
		System.out.println("text is not matching");

	}
	WebElement AddSkills=driver.findElement(By.xpath("//*[@id='ecv_add_skill_link_16240']"));

//	js.executeScript("arguments[0].scrollIntoView();", AddSkills);
	js.executeScript("scroll(0,900)");

	System.out.println(AddSkills.getText());
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ecv_add_skill_link_16240']")));

	AddSkills.click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user_ecv_primary_skill_primary_skill_id']")));
	WebElement Selectskill=driver.findElement(By.xpath(".//*[@id='user_ecv_primary_skill_primary_skill_id']"));
	Selectskill.click();
	//Step 8 Select skill and it in text box
	
	Select sel=new Select(Selectskill) ;
	sel.selectByVisibleText("Testing");
	Thread.sleep(400);
//	driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys("Selenium");
//	Thread.sleep(100);
//	driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys(Keys.ENTER);
//	Thread.sleep(200);
	WebElement textbox=driver.findElement(By.xpath(".//*[@id='user_ecv_primary_skill_more_info']"));
			textbox.sendKeys("Selenium");
			textbox.sendKeys("Junit");
			textbox.sendKeys("Java");
			
			WebElement Saveskill=driver.findElement(By.xpath(".//*[@id='ecv_skill_5200']/div[3]/div/div/input[2]"));
			if(Saveskill.isEnabled())
			{
			Saveskill.click();
			}
			
			else 
			{
				System.out.println("save button is not enabled");
			}
			
			driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys("Sele");
			Thread.sleep(100);
			driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys(Keys.DOWN);
		
			Thread.sleep(200);
//	driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys("testng");
//	driver.findElement(By.xpath(".//ul[@class='token-input-list-facebook']")).sendKeys("Java");
	
	
//			driver.quit();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		// TODO Auto-generated method stub

	}
	
}
