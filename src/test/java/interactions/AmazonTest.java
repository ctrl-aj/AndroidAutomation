package interactions;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AmazonTest {

	static AndroidDriver<MobileElement> driver;
	
	public AmazonTest() {
		/*Ricerco un prodotto e apro il primo risultato della ricerca*/
	}
	
	public static void main(String[] args) {
		
		try {
			launchTest();
			System.out.println("Test Amazon eseguito correttamente");
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
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Amazon Shopping");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		
		MobileElement el4 = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/query_entry_autocomplete_text_view");
		el4.click();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el5 = (MobileElement) driver.findElementById("com.amazon.mShop.android.shopping:id/query_entry_autocomplete_text_view");
		el5.sendKeys("attrezzi");
		(new TouchAction(driver)).tap(PointOption.point(734, 1051)).perform();
		TimeUnit.SECONDS.sleep(10);
		MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]");
		el6.click();
		TimeUnit.SECONDS.sleep(10);
		
		
	}

}
