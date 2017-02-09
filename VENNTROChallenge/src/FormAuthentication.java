import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FormAuthentication {
	
	@Test
	public void SuccessfulLogin(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String successmsg = driver.findElement(By.xpath(".//*[@id='flash']")).getText();
		Assert.assertTrue(successmsg.contains("You logged into a secure area!")); 
		System.out.println(driver.findElement(By.xpath(".//*[@id='flash']")).getText());
	}
	
	@Test
	public void UnsuccessfulLogin(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("xyz");
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String errormsg = driver.findElement(By.xpath(".//*[@id='flash']")).getText();
		Assert.assertTrue(errormsg.contains("Your username is invalid!"));
		System.out.println(driver.findElement(By.xpath(".//*[@id='flash']")).getText());
		
	}

}
