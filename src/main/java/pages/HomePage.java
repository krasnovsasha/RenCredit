package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	public void chooseDeposit(String optionName) {
		waitClickable(optionLeftMenu(optionName)).click();
	}

	private WebElement optionLeftMenu(String option) {
		WebElement optionLeft = findElement(By.xpath(String.format("//div[contains(text(),'%s')]/preceding-sibling::a", option)));
		return optionLeft;
	}
}
