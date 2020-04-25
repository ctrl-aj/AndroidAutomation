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

public class GooglenewsCheck {

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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("News");
		el1.click();
		TimeUnit.SECONDS.sleep(10);
		ArrayList<String> output = new ArrayList<String>();
		int i=0;
		while(i<5) {
			ArrayList<MobileElement> titoli = (ArrayList<MobileElement>) driver.findElementsById("com.google.android.apps.magazines:id/title");
			for(int j=0;j<titoli.size();j++) {
				output.add(titoli.get(j).getText());
				System.out.println(titoli.get(j).getText());
			}
			(new TouchAction(driver))
			  .press(PointOption.point(42,1138))
			  .moveTo(PointOption.point(37,114))
			  .release()
			  .perform();
			(new TouchAction(driver))
			  .press(PointOption.point(42,1138))
			  .moveTo(PointOption.point(37,114))
			  .release()
			  .perform();
			i++;
		}  
		
		String outputString = "";
		for(int j=0;j<output.size();j++) {
			outputString+=output.get(i);
		}
		
		
		File outputCode = new File("/home/antonio/Desktop/GoogleNews.txt");
		FileWriter fr = new FileWriter(outputCode, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(outputString);
		br.close();
		fr.close();
		System.out.println("Articoli Google News Scaricati");
		
	}

}
