package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {
	@FindBy(xpath = "//input[@name='amount']")
	private WebElement amount;
	@FindBy(id = "period-styler")
	private WebElement time;
	@FindBy(xpath = "//input[@name='replenish']")
	private WebElement monthlyPay;
	@FindBy(xpath = "//span[contains(text(),'капитализация')]")
	private WebElement capitalization;
	@FindBy(xpath = "//span[@class = 'js-calc-earned']")
	private WebElement earned;
	@FindBy(xpath = "//span[@class = 'js-calc-replenish']")
	private WebElement replenishment;
	@FindBy(xpath = "//span[@class = 'js-calc-result']")
	private WebElement result;

	public void chooseCurrency(String currencyName) {
		waitUntilElementToBeClickable(getCurrency(currencyName));
		getCurrency(currencyName).click();
	}

	private WebElement getCurrency(String name) {
		return findElement(By.xpath(String.format("//span[contains(text(),'%s')]", name)));
	}

	public void fillData(String data) {
		waitClickable(time).click();
		WebElement hiddenData = findElement(By.xpath(String.format("//ul/li[contains(text(),'%s')]", data)));
		hiddenData.click();
	}

	public void fillField(WebElement element, String data) {
		waitUntilElementToBeClickable(element);
		element.click();
		element.sendKeys(data);
		waitUntilElementToBeVisible(element);
	}

	public void fillFields(String fieldName, String data) {
		switch (fieldName) {
			case "Сумма вклада":
				fillField(amount, data);
				break;
			case "На срок":
				fillData(data);
				break;
			case "Ежемесячное пополнение":
				fillField(monthlyPay, data);
				break;
		}
	}

	public void clickCapitalization() {
		moveToElement(capitalization);
		waitClickable(capitalization).click();
	}

	public void checkFields(String fieldName, String value) {
		switch (fieldName) {
			case "Начислено %":
				Assert.assertEquals("Фактическое значение не равно ожидаемому ", value, earned.getText());
				break;
			case "Пополнение за 9 месяцев":
				Assert.assertEquals("Фактическое значение не равно ожидаемому ", value, replenishment.getText());
				break;
			case "К снятию через 9 месяцев":
				Assert.assertEquals("Фактическое значение не равно ожидаемому ", value, result.getText());
				break;
		}
	}
}
