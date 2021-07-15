package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.channels.Selector;


public class BaseTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static AndroidDriver driver;
    public static FluentWait<AndroidDriver> wait;
    private boolean localAndroid = true;
    private Selector selector;

    @Before
    public void beforePlan(){
        logger.info("*****Test Başlatıldı****");
    }

    @BeforeScenario
    public void beforeScenario() throws Exception {
        driver = BrowserExec.getAppiumDriver();
        logger.info("App has started");
    }

    @After
    public void after(){
        logger.info("*****Test Bitti*****");
    }

    @AfterScenario
    public void afterScenario() {
        driver.quit();
    }
}