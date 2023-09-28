package BeymenApp.base;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    static AppiumDriver appiumDriver = null;

    public static WebDriverWait wait;

    @BeforeClass

    public void setup() {
        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();
            cap.setCapability("deviveName", "EDA");
            cap.setCapability("platformName", "Android");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("appPackage", "com.mobisoft.beymen");
            cap.setCapability("appActivity", "com.mobisoft.beymen.activity.SplashActivity");

            appiumDriver = new AndroidDriver(new URL("\"http://127.0.0.1:4723/wd/hub"), cap);
            wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));

        }
        catch(MalformedURLException mx){
                System.out.println("Hatalı");
            }
        }


        public static AppiumDriver getAppiumDriver(){
        return appiumDriver;
        }

        public static void setAppiumDriver(AppiumDriver appiumDriver){
        BaseTest.appiumDriver = appiumDriver;
        }

        public void tearDown(){
        getAppiumDriver().quit();
        }
    }



