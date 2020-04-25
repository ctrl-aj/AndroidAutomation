package appiumTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TalkingtomTest {

	static AppiumDriver<MobileElement> driver;
	
	public TalkingtomTest() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test TalkingTom eseguito correttamente");
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
		


		MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Il Mio Tom 2");
		el.click();
		TimeUnit.SECONDS.sleep(30);
		(new TouchAction(driver)).tap(PointOption.point(752, 123)).perform();
		TimeUnit.SECONDS.sleep(10);
		(new TouchAction(driver)).tap(PointOption.point(746, 128)).perform();
		TimeUnit.SECONDS.sleep(10);
		(new TouchAction(driver)).tap(PointOption.point(742, 56)).perform();

		
		
	}

}



