package pages;

import baseSettings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

abstract class BasePage {
	private static  FluentWait<WebDriver> fluentWait;
	public BasePage() {
		PageFactory.initElements(DriverSettings.getDriver(), this);
	}

	protected WebElement waitClickable(WebElement element) {
		return DriverSettings.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	protected WebElement findElement(By by) {
		return DriverSettings.getDriver().findElement(by);
	}

	protected void moveToElement(WebElement element) {
		Actions actions = new Actions(DriverSettings.getDriver());
		actions.moveToElement(element).perform();
	}

	protected static void waitUntilElementToBeVisible(WebElement element) {
		fluentWait = new FluentWait<>(DriverSettings.getDriver())
					.withTimeout(Duration.ofMillis(10000))
					.pollingEvery(Duration.ofMillis(1000))
					.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilElementToBeClickable(WebElement element)
	{
		FluentWait<WebDriver> ClickableWait = new FluentWait<WebDriver>(DriverSettings.getDriver())
				.withTimeout(Duration.ofMillis(10000))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class);

		ClickableWait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
