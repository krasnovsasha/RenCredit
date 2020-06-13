package pages;

import baseSettings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract class BasePage {
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

	protected WebElement waitVisibility(WebElement element) {
		return (WebElement) DriverSettings.getFluentWait().until(ExpectedConditions.visibilityOf(element));
	}
}
