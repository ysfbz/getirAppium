package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import java.net.URL;

public class BrowserExec {
    private static AndroidDriver driver;
    private FluentWait<AndroidDriver> wait;
    static DesiredCapabilities desiredCapabilities;

    public static AndroidDriver getAppiumDriver() throws Exception {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel");
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        desiredCapabilities.setCapability("avd","pixel");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.allandroidprojects.getirsample");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.allandroidprojects.getirsample.startup.SplashActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,desiredCapabilities);
        return driver;
        }

}