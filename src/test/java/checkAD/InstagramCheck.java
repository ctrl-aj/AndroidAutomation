package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
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
import org.openqa.selenium.interactions.Actions;

public class InstagramCheck {
	
	
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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Instagram");
		el1.click();
		TimeUnit.SECONDS.sleep(10);
		String output ="";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"Sponsorizzato\"));");
		TimeUnit.SECONDS.sleep(10);
		ArrayList<MobileElement> list = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		for(int j=0;j<list.size();j++) {
			output +=list.get(j).getText()+"\n";
		}
		
		TimeUnit.SECONDS.sleep(3);
		(new TouchAction(driver)) 
			  .press(PointOption.point(390,978))
			  .moveTo(PointOption.point(387,472))
			  .release()
			  .perform();
		
		TimeUnit.SECONDS.sleep(3);
		(new TouchAction(driver))  
		  .press(PointOption.point(390,978))
		  .moveTo(PointOption.point(387,472))
		  .release()
		  .perform();
		
	/*	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"Sponsorizzato\"));");
		TimeUnit.SECONDS.sleep(3);
		ArrayList<MobileElement> list2 = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
		for(int j=0;j<list2.size();j++) {
			output +=list2.get(j).getText()+"\n";
		}
		*/
		File outputCode = new File("/home/antonio/Desktop/Instagram.txt");
		FileWriter fr = new FileWriter(outputCode, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(output);
		br.close();
		fr.close();
		System.out.println("Codice Scaricato");
		
	}
	

}
