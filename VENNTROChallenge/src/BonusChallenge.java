import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BonusChallenge {

	@Test
	public void dynamicLoading() throws InterruptedException
	{
		//Test below first checks that loading element is shown after clicking start
		///isDisplayed() is used to validate that Helloworld message is displayed
		WebDriver driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		System.out.println("Before click:"+driver.findElements(By.xpath(".//*[@id='loading']/img")).size());
		driver.findElement(By.xpath(".//*[@id='start']/button")).click();
		Thread.sleep(2000);
		System.out.println("After click:"+driver.findElements(By.xpath(".//*[@id='loading']/img")).size());
		driver.findElement(By.xpath(".//*[@id='finish']/h4")).isDisplayed();
	}
	
	
	@Test
	public void Retrieveemail()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/tables");
		String email = driver.findElement(By.xpath(".//*[@id='table1']/tbody/tr[3]/td[3]")).getText();
		System.out.println(email);
	}
	
	
}
