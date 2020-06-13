package baseSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SingleProperty;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverSettings {
	private static WebDriver driver;
	private static WebDriverWait wait;

	private static Properties properties = SingleProperty.getInstance().getProperties();
	protected static String urlMainPage;

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriverWait getWait() {
		return wait;
	}

	public static void setUp() {
		setUpBrowser(System.getProperty("browser", "chrome"));
		urlMainPage = properties.getProperty("indexURL");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		driver.get(urlMainPage);
	}

	private static void setUpBrowser(String browserName) {
		String[] osName = System.getProperty("os.name").toLowerCase().split("\\s");
		switch (osName[0]) {
			case "linux":
				switch (browserName) {
					case "chrome":
						System.setProperty(properties.getProperty("driverChrome"), properties.getProperty("pathToDriverChromeLin"));
//						ChromeOptions option = new ChromeOptions();
//						option.setHeadless(true);
//						driver = new ChromeDriver(option);
						driver = new ChromeDriver();
						break;
					case "firefox":
						System.setProperty(properties.getProperty("driverFirefox"), properties.getProperty("pathToDriverFirefoxLin"));
						driver = new FirefoxDriver();
						break;
				}
				break;
			case "windows":
				switch (browserName) {
					case "chrome":
						System.setProperty(properties.getProperty("driverChrome"), properties.getProperty("pathToDriverChromeWin"));
						ChromeOptions option = new ChromeOptions();
						option.setHeadless(true);
						driver = new ChromeDriver(option);
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
						ChromeOptions option = new ChromeOptions();
						option.setHeadless(true);
						driver = new ChromeDriver(option);
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

