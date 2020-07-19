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

public class ChromeTest {

	static AppiumDriver<MobileElement> driver;
	
	public ChromeTest() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test Chrome eseguito correttamente");
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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Chrome");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		MobileElement el2 = (MobileElement) driver.findElementById("com.android.chrome:id/search_box_text");
		el2.click();
		TimeUnit.SECONDS.sleep(5);
		MobileElement el3 = (MobileElement) driver.findElementById("com.android.chrome:id/search_box_text");
		el3.sendKeys("gay");
		TimeUnit.SECONDS.sleep(5);
		(new TouchAction(driver)).tap(PointOption.point(734, 1051)).perform();
		TimeUnit.SECONDS.sleep(10);
		try {
			MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[7]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View");
			el4.click();
		}
		catch(Exception e) {
			System.out.println("Primo risultato non presente");
		}
		
	}

}

