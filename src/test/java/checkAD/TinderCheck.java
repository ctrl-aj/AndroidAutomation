package checkAD;

import java.io.File;
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

public class TinderCheck {
	
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String args[]) {
		
		try {
			launchCheck();
			System.out.println("Test terminato");
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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Tinder");
		el1.click();
		TimeUnit.SECONDS.sleep(35);
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ImageView");
		
		MobileElement el3 = null;
		MobileElement el4 = null;
		MobileElement el5 = null;
		
		while(el3==null && el4==null && el5==null) {	
			
			try {
				el5 = driver.findElementById("com.tinder:id/fan_ad_media_view");
			}
			catch(Exception e) {
				el5 = null;
			}
			
			try {
				el3 = driver.findElementById("com.tinder:id/loading_button_text");
			}
			catch(Exception e) {
				el3=null;
			}
			System.out.println(el3);
			try {
				driver.findElementById("com.tinder:id/recs_status_message");

			}
			catch(Exception e) {
				el4=null;
			}
			el2.click();
			TimeUnit.SECONDS.sleep(5);
		}
		
		if(el3!=null) {
			el2.click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Tinder.png"));
			System.out.println("Screenshoot eseguito");
			driver.closeApp();
		}
		if(el5!=null) {
			el2.click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/Tinder2.png"));
			System.out.println("Screenshoot eseguito");
			driver.closeApp();
		}
		if(el4!=null) {
			driver.closeApp();
		}
		
	}
	

}
