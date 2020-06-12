package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(xpath = "//div[contains(text(),'Вклады')]/preceding-sibling::a")
	private WebElement deposit;

	public void chooseDeposit(String optionName) {
		switch (optionName) {
			case "Вклады":
				waitClickable(deposit).click();
				break;
		}
	}
}
