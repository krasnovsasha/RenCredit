package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {
	@FindBy(xpath = "//span[contains(text(),'Рубли')]")
	private WebElement currencyRUB;
	@FindBy(xpath = "//span[contains(text(),'Доллары')]")
	private WebElement currencyUSA;
	@FindBy(xpath = "//label[contains(text(),'Сумма вклада')]/parent::div//input")
	private WebElement amount;
	@FindBy(xpath = "//div[@class='jq-selectbox__select-text']")
	private WebElement time;
	@FindBy(xpath = "//input[@name='replenish']")
	private WebElement monthlyPay;
	@FindBy(xpath = "//span[text()='Ежемесячная капитализация']")
	private WebElement capitalization;
	@FindBy(xpath = "//span[@class = 'js-calc-earned']")
	private WebElement earned;
	@FindBy(xpath = "//span[@class = 'js-calc-replenish']")
	private WebElement replenishment;
	@FindBy(xpath = "//span[@class = 'js-calc-result']")
	private WebElement result;

	public void chooseCurrency(String currencyName) {
		switch (currencyName) {
			case "Рубли":
				waitClickable(currencyRUB).click();
				break;
			case "Доллары":
				waitClickable(currencyUSA).click();
				break;
		}
	}

	public void fillData(String data) {
		waitClickable(time).click();
		WebElement hiddenData = findElement(By.xpath(String.format("//div[@class='jq-selectbox__dropdown']//li[contains(text(),'%s')]", data)));
		hiddenData.click();
	}

	public void fillField(WebElement element, String data) {
		element.click();
		element.sendKeys(data);
		waitAMoment(500);
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
		waitAMoment(500);
	}

	public void checkFields(String fieldName, String value) {
		String actual;
		switch (fieldName) {
			case "Начислено %":
				actual = earned.getText();
				Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, actual), visibilityText(earned, value));
				break;
			case "Пополнение за 9 месяцев":
				actual = replenishment.getText();
				Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, actual), visibilityText(replenishment, value));
				break;
			case "К снятию через 9 месяцев":
				actual = result.getText();
				Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, actual), visibilityText(result, value));
				break;
		}
	}
}
