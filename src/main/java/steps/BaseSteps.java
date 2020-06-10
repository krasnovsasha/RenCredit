package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
	private static WebDriver driver;
	public static WebDriverWait wait;
	private static Properties properties = SingleProperty.getInstance().getProperties();
	protected static String urlMainPage;
	private static ChromeOptions options;
	private static FirefoxOptions optionsFox;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUp() {
		setUpBrowser(System.getProperty("browser", "chrome"));
		urlMainPage = properties.getProperty("indexURL");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get(urlMainPage);
	}

	private static void setUpBrowser(String browserName) {
		String[] osName = System.getProperty("os.name").toLowerCase().split("\\s");
		switch (osName[0]) {
			case "linux":
				switch (browserName) {
					case "chrome":
						System.setProperty(properties.getProperty("driverChrome"), properties.getProperty("pathToDriverChromeLin"));
						driver = new ChromeDriver(options);
						break;
					case "firefox":
						System.setProperty(properties.getProperty("driverFirefox"), properties.getProperty("pathToDriverFirefoxLin"));
						driver = new FirefoxDriver(optionsFox);
						break;
				}
				break;
			case "windows":
				switch (browserName) {
					case "chrome":
						System.setProperty(properties.getProperty("driverChrome"), properties.getProperty("pathToDriverChromeWin"));
						driver = new ChromeDriver();
						break;
					case "firefox":
						System.setProperty(properties.getProperty("driverFirefox"), properties.getProperty("pathToDriverFirefoxWin"));
						driver = new FirefoxDriver();
						break;
				}
				break;
			case "mac":
				switch (browserName) {
					case "chrome":
						System.setProperty(properties.getProperty("driverChrome"), properties.getProperty("pathToDriverChromeMac"));
						driver = new ChromeDriver();
						break;
					case "firefox":
						System.setProperty(properties.getProperty("driverFirefox"), properties.getProperty("pathToDriverFirefoxMac"));
						driver = new FirefoxDriver();
						break;
				}
				break;
		}
	}

	public static void tearDown() {
		driver.quit();
	}
}

