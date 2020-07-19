package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

public class YoutubeCheck {
	
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String args[]) {
		
		try {
			launchCheck();
			System.out.println("Test Terminato");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void launchCheck() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy S8+");
		cap.setCapability("udid", "SP1CYXXX1911003374");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("YouTube");
		el1.click();
		TimeUnit.SECONDS.sleep(10);
		
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Cerca");
		el2.click();
		TimeUnit.SECONDS.sleep(10);
		
		MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.youtube:id/search_edit_text");
		el3.sendKeys("breaking italy ronde");
		TimeUnit.SECONDS.sleep(10);
		
		(new TouchAction(driver)).tap(PointOption.point(736, 1051)).perform();
		TimeUnit.SECONDS.sleep(10);
		
		(new TouchAction(driver)).tap(PointOption.point(111, 111)).perform();
		TimeUnit.SECONDS.sleep(10);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Youtube1.png"));
		System.out.println("Screenshoot eseguito");
		
		TimeUnit.SECONDS.sleep(10);
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("/home/antonio/Desktop/Youtube2.png"));
		System.out.println("Screenshoot eseguito");
		
	}

}
