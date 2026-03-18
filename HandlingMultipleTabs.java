package handling_popups;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleTabs {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://demoapps.qspiders.com/");
	driver.findElement(By.xpath("//*[text()='UI Testing Concepts']")).click();
	driver.findElement(By.xpath("//*[text()='Popups']")).click();
	driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
	driver.findElement(By.xpath("//*[text()='New Tab']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//h2[text()='Watches']/following-sibling::button[text()='view more']")).click();
	Set<String> allwid = driver.getWindowHandles();
	Iterator<String> i = allwid.iterator();
	String pwid = i.next();
	String cwid = i.next();
	driver.switchTo().window(cwid);
	System.out.println(driver.getCurrentUrl());
	driver.close();
	Thread.sleep(2000);
	driver.switchTo().window(pwid).close();
	}
}
