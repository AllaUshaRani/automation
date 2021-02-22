package qaclick;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logo {
	
	@Test
	public void test2() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//img[@src=\"images/rs_logo.png\"]"));
		driver.close();
	}

}
