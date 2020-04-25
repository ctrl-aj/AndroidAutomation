package checkAD;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

public class AmazonCheck {
	
	
	static AppiumDriver<MobileElement> driver;
	
	public static void main(String args[]) {
		
		try {
			launchCheck();
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
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Amazon Shopping");
		el1.click();
		TimeUnit.SECONDS.sleep(5);
		int i=0;
		while(i<5) {
			(new TouchAction(driver))
			  .press(PointOption.point(390,1139))
			  .moveTo(PointOption.point(408,214))
			  .release()
			  .perform();
			TimeUnit.SECONDS.sleep(5);
			i++;
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Amazon"+i+".png"));
			System.out.println("Screenshoot eseguito");
		} 
		TimeUnit.SECONDS.sleep(10);
		MobileElement el4 = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/query_entry_autocomplete_text_view");
		el4.click();
		TimeUnit.SECONDS.sleep(5);
		MobileElement el5 = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/query_entry_autocomplete_text_view");
		el5.sendKeys("attrezzi");
		TimeUnit.SECONDS.sleep(5);
		MobileElement el6 = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/query_entry_autocomplete_text_view");
		el6.click();
		TimeUnit.SECONDS.sleep(5);
		(new TouchAction(driver)).tap(PointOption.point(730, 1054)).perform();
		TimeUnit.SECONDS.sleep(5);
		i=0;
		while(i<5) {
			(new TouchAction(driver))
			  .press(PointOption.point(390,1139))
			  .moveTo(PointOption.point(408,214))
			  .release()
			  .perform();
			TimeUnit.SECONDS.sleep(5); 
			i++;
		} 
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Amazon6.png"));
		System.out.println("Screenshoot eseguito");
		
		
	}
	

}
