package interactions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class LinkedinTest {

	static AppiumDriver<MobileElement> driver;
	
	public LinkedinTest() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test Linkedin eseguito correttamente");
		}
		
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void launchTest() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy S8+");
		cap.setCapability("udid", "SP1CYXXX1911003374");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("LinkedIn");
		el1.click();
		TimeUnit.SECONDS.sleep(20);
		MobileElement el2 = (MobileElement) driver.findElementById("com.linkedin.android:id/search_bar_text");
		el2.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el3 = (MobileElement) driver.findElementById("com.linkedin.android:id/search_bar_text");
		el3.sendKeys("salvini");
		TimeUnit.SECONDS.sleep(10);
		MobileElement el4 = (MobileElement) driver.findElementById("com.linkedin.android:id/search_typeahead_see_all_button");
		el4.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Filtra per Gruppi\"]/android.widget.LinearLayout/android.widget.TextView");
		el5.click();
		
	}

}
