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

public class TripadvisorTest {

	static AppiumDriver<MobileElement> driver;
	
	public TripadvisorTest() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test TripAdvisor eseguito correttamente");
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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Tripadvisor");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]");
		el2.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el3 = (MobileElement) driver.findElementById("com.tripadvisor.tripadvisor:id/picker_typeahead");
		el3.sendKeys("barcellona");
		TimeUnit.SECONDS.sleep(10);
		MobileElement el4 = (MobileElement) driver.findElementById("com.tripadvisor.tripadvisor:id/airport_title");
		el4.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el5 = (MobileElement) driver.findElementById("com.tripadvisor.tripadvisor:id/search_flights_button");
		el5.click();
		
		
		
	}

}



