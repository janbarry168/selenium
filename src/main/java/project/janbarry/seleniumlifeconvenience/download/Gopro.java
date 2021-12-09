package project.janbarry.seleniumlifeconvenience.download;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gopro {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\App\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		
		try {
			String baseUrl = "https://gopro.com/v/OWDO1yQKVnPnr/";
			List<String> urlList = new ArrayList<>();
			
			driver.get(baseUrl);
			List<WebElement> aTagList = driver.findElements(By.cssSelector(".grid-row a"));
			for (WebElement aTag : aTagList) {
				String href = aTag.getAttribute("href");
				urlList.add(href);
			}
			
			for (String url : urlList) {
				driver.get(url);
				Thread.sleep(1000);
				
				run(driver);
//				runJavascript(jsDriver);
			}
		} finally {
			driver.quit();
		}

	}
	
	private static void run(WebDriver driver) {
		WebElement button = driver.findElement(By.cssSelector(".toolbar button"));
		button.click();
		WebElement download = driver.findElement(By.cssSelector(".icon-download-stroke"));
		download.click();
	}
	
	private static void runJavascript(JavascriptExecutor js) throws InterruptedException {
		js.executeScript("document.querySelector(\".icon-download-stroke\").click()");
	}

}
