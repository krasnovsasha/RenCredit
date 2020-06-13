package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(xpath = "//div[@class='services services_main']")
	WebElement formHomePage;
	public void chooseDeposit(String optionName) {
		waitClickable(optionLeftMenu(optionName)).click();
	}

	private WebElement optionLeftMenu(String option) {
		WebElement optionLeft = formHomePage.findElement(By.xpath(String.format("//div[contains(text(),'%s')]/preceding-sibling::a", option)));
		return optionLeft;
	}
}
