package checkAD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

public class YoutubeCheck {
	
	
	static AndroidDriver<MobileElement> driver;
	
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
		cap.setCapability("udid", "SP1CYXXX1911003374");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("YouTube");
		el1.click();
		
		TimeUnit.SECONDS.sleep(5);
		String pageSource = driver.getPageSource();
		
		if(pageSource.contains("resource-id=\"com.google.android.youtube:id/ad_attribution\"")) {
			ArrayList<MobileElement> list = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
			String output ="";
			for(int i=0;i<list.size();i++) {
				output+=list.get(i).getText();
			}
			File outputCode = new File("/home/antonio/Desktop/Youtube.txt");
			FileWriter fr = new FileWriter(outputCode, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(output);
			br.close();
			fr.close();
			System.out.println("Codice Scaricato");
		}
		else {
			System.out.println("Codice non Scaricato");
		}
		
	}

}
