import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynamicControls {
	
	@Test
	public void DynamicControl() throws InterruptedException
	{
		//Test checks remove button removes checkbox and that confirmation msg is shown
		//and then the add button returns the checkbox and that the confirmation msg is shown	
		WebDriver driver=new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		System.out.println("Before click:"+driver.findElements(By.xpath("//input[@id='checkbox']")).size());
		driver.findElement(By.id("btn")).click();
		Thread.sleep(5000);
		System.out.println("After click:"+driver.findElements(By.xpath("//input[@id='checkbox']")).size());
		System.out.println(driver.findElement(By.xpath(".//*[@id='message']")).getText());
		System.out.println("------");
		Thread.sleep(5000);
		System.out.println("Before click:"+driver.findElements(By.xpath("//input[@id='checkbox']")).size());
		driver.findElement(By.id("btn")).click();
		Thread.sleep(5000);
		System.out.println("After click:"+driver.findElements(By.xpath("//input[@id='checkbox']")).size());
		System.out.println(driver.findElement(By.xpath(".//*[@id='message']")).getText());
	}

}
