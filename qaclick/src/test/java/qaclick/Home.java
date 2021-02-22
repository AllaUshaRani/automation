package qaclick;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home {

	WebDriver driver = null;

	// @Test
	public void testHomePage() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click(); // Clicing on Home button

		String title = driver.getTitle();
		Assert.assertEquals("Rahul Shetty Academy", title);

	}

	@BeforeMethod
	public void testFirstPage() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		Assert.assertEquals("Practice Page", title);

	}

	@Test
	public void testRadioButton() throws InterruptedException {

		// This method is for selecting radio button
		driver.findElement(By.xpath("//*[@value=\"radio2\"]")).click();

		driver.findElement(By.xpath("//*[@id=\'autocomplete\']")).sendKeys("India");
		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void testdropdown() throws InterruptedException {

		driver.findElement(By.xpath("//*[contains(text(),\'Dropdown Example\')]"));
		WebElement element = driver.findElement(By.xpath("//*[@id=\'dropdown-class-example\']"));
		Select optionDropdown = new Select(element);
		optionDropdown.selectByVisibleText("Option1");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void testcheckbox() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='checkBoxOption2']")).click();
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void testswitchtoalert() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\'name\']")).sendKeys("usha");
		driver.findElement(By.xpath("//*[@id=\'confirmbtn\']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.close();

	}

	@Test
	public void testopenwindow() {
		driver.findElement(By.xpath("//*[@id=\'openwindow\']")).click();

		String title = driver.getTitle();
		Assert.assertEquals("Practice Page", title);
		driver.close();
	}

	@Test
	public void testOpentab() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='opentab']")).click();

		// It will return the parent window name as a String
		String parentWindow = driver.getWindowHandle();

		Set<String> setOfWindows = driver.getWindowHandles();

		for (String child_window : setOfWindows) {

			if (!(parentWindow.equals(child_window))) {
				driver.switchTo().window(child_window);

				String title = driver.switchTo().window(child_window).getTitle();

				Assert.assertEquals("Rahul Shetty Academy", title);
				driver.quit();
			}

		}

	}

	@Test
	public void testElementDisplyId() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='displayed-text']")).sendKeys("usharani");
		driver.findElement(By.xpath("//*[@id=\'hide-textbox\']")).click();
		Thread.sleep(2000);
		driver.close();

	}

	@Test
	public void testTable() throws InterruptedException {
		WebElement element = driver.findElement(By.id("product"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.xpath("//*[@class=\"left-align\"]/fieldset[1]/table/tbody/tr[2]/td[3]"));
		Thread.sleep(12000);
		
		driver.close();

	}

}
