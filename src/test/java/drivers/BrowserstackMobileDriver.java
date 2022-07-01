package drivers;
import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);


        mutableCapabilities.setCapability("browserstack.user", config.browserstackUser());
        mutableCapabilities.setCapability("browserstack.key", config.browserstackKey());


        mutableCapabilities.setCapability("app", config.app());


        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version", config.osVersion());


        mutableCapabilities.setCapability("project", "First Junit5 Android Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);
            return new URL(browserstackConfig.browserstackURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
