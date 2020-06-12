package pages;

import baseSettings.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract class BasePage {
	public BasePage() {
		PageFactory.initElements(BaseSteps.getDriver(), this);
	}

	protected WebElement waitClickable(WebElement element){
		return BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	protected WebElement findElement(By by) {
		return BaseSteps.getDriver().findElement(by);
	}
	protected void moveToElement(WebElement element){
		Actions actions = new Actions(BaseSteps.getDriver());
		actions.moveToElement(element).perform();
	}
	protected void waitAMoment(long mlSeconds){
		try {
			Thread.sleep(mlSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Boolean visibilityText(WebElement element, String text) {
		return BaseSteps.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

}
