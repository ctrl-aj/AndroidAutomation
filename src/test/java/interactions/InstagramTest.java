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

public class InstagramTest {

	static AppiumDriver<MobileElement> driver;
	
	public InstagramTest() {
		/*Metto un like al primo post e faccio la ricerca di un account*/
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test Instagram eseguito correttamente");
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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Instagram");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		(new TouchAction(driver))
		  .press(PointOption.point(398,778))
		  .moveTo(PointOption.point(402,632))
		  .release()
		  .perform();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mi piace");
		el2.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Cerca ed esplora");
		el3.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el4 = (MobileElement) driver.findElementById("com.instagram.android:id/action_bar_search_edit_text");
		el4.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el5 = (MobileElement) driver.findElementById("com.instagram.android:id/action_bar_search_edit_text");
		el5.sendKeys("gym");
		TimeUnit.SECONDS.sleep(10);
		(new TouchAction(driver)).tap(PointOption.point(736, 1051)).perform();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
		el6.click();
	}

}
