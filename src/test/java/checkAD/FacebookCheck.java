package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

public class FacebookCheck {
	
	
	static AndroidDriver<MobileElement> driver;
	
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
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Facebook");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		int i=0;
		while(i<15) {
			(new TouchAction(driver))
			  .press(PointOption.point(19,1203))
			  .moveTo(PointOption.point(21,118))
			  .release()
			  .perform();
			i++;
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Facebook"+i+".png"));
			System.out.println("Screenshoot eseguito");
			TimeUnit.SECONDS.sleep(5);
		}
	}
	

}
