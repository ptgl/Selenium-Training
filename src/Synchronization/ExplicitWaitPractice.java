package Synchronization;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitPractice {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		String username = driver.findElement(By.xpath("(//i)[1]")).getText();
		String password = driver.findElement(By.xpath("(//i)[2]")).getText();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[normalize-space()='User' and @class='radiotextsty']")).click();
		
		w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select jobType = new Select(dropdown);
		jobType.selectByValue("consult");
		
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-footer']/button")));
		List<WebElement> addBtns = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
		for(WebElement e : addBtns) {
			e.click();
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
	}
}
