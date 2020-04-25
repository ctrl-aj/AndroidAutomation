package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.List;
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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

public class WebmdCheck {
	
	
	static AppiumDriver<MobileElement> driver;
	
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
		cap.setCapability("udid", "ce051715707064660d");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("WebMD");
		el1.click();
		
		TimeUnit.SECONDS.sleep(5);
		MobileElement el2 = (MobileElement) driver.findElementById("com.webmd.android:id/search_box_text_view");
		el2.click();
		
		TimeUnit.SECONDS.sleep(5);
		MobileElement el3 = (MobileElement) driver.findElementById("com.webmd.android:id/home_search_toolbar_edit_text");
		el3.sendKeys("a");
		
		TimeUnit.SECONDS.sleep(5);
		MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
		el4.click();
		
		TimeUnit.SECONDS.sleep(5);
		(new TouchAction(driver))
		  .press(PointOption.point(468,2019))
		  .moveTo(PointOption.point(510,1025))
		  .release()
		  .perform();
		  
		(new TouchAction(driver))
		  .press(PointOption.point(479,1354))
		  .moveTo(PointOption.point(501,894))
		  .release()
		  .perform();
		  
		(new TouchAction(driver))
		  .press(PointOption.point(460,964))
		  .moveTo(PointOption.point(512,310))
		  .release()
		  .perform();
		
		String pageSource = driver.getPageSource();
		if(pageSource.contains("com.webmd.android:id/adLabel")) {
			if((pageSource.contains("resource-id=\"squareish\"")) || (pageSource.contains("resource-id=\"rectangle-banner\""))) {
				File outputCode = new File("/home/antonio/Desktop/WebMD.txt");
				FileWriter fr = new FileWriter(outputCode, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.write(pageSource);
				br.close();
				fr.close();
				System.out.println("Codice Scaricato");
			}
			else {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/WebMD.png"));
				System.out.println("Screenshoot eseguito");
			}	
			
		}

		else {
				System.out.println("Screenshot non eseguito pubblicità non presente");
		}
		
	}
	

}
