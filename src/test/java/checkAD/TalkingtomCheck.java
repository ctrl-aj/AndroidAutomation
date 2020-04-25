package checkAD;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TalkingtomCheck {
	
	static AppiumDriver<MobileElement> driver;
	
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
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Il Mio Tom 2");
		el1.click();
		TimeUnit.SECONDS.sleep(30);
		(new TouchAction(driver)).tap(PointOption.point(747, 128)).perform();
		TimeUnit.SECONDS.sleep(20);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/home/antonio/Desktop/TalkingTom1.png"));
		System.out.println("Screenshoot eseguito");
		TimeUnit.SECONDS.sleep(10);
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("/home/antonio/Desktop/TalkingTom2.png"));
		System.out.println("Screenshoot eseguito");
	}
}
