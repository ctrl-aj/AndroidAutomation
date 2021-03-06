package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TripadvisorCheck {

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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Tripadvisor");
		el1.click();
		TimeUnit.SECONDS.sleep(35);
		
		(new TouchAction(driver)).tap(PointOption.point(373, 741)).perform();

		String output ="";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"Migliora questo profilo\"));");
		
		ArrayList<MobileElement> list = (ArrayList<MobileElement>) driver.findElementsByClassName("android.view.View");
		for(int j=0;j<list.size();j++) {
			output +=list.get(j).getText();
		}
		
		File outputCode = new File("/home/antonio/Desktop/TripAdvisor.txt");
		FileWriter fr = new FileWriter(outputCode, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(output);
		br.close();
		fr.close();
		System.out.println("Codice TripAdvisor scaricato");
	}
}
