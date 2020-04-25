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

public class ChromeCheck {

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
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Chrome");
		el1.click();
		TimeUnit.SECONDS.sleep(15);
		
		String output ="";
		int i=0;
		while(i<5) {
			ArrayList<MobileElement> list = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
			for(int j=0;j<list.size();j++) {
				output +=list.get(j).getText()+"\n";
			}
			(new TouchAction(driver))
			  .press(PointOption.point(42,1138))
			  .moveTo(PointOption.point(37,114))
			  .release()
			  .perform();
			i++;
			TimeUnit.SECONDS.sleep(5);
		}
		
		File outputCode = new File("/home/antonio/Desktop/Chrome.txt");
		FileWriter fr = new FileWriter(outputCode, true);
		BufferedWriter br = new BufferedWriter(fr);
		br.write(output);
		br.close();
		fr.close();
		System.out.println("Articoli Chrome scaricati");
		
	}
}
