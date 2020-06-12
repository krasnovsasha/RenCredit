package pageSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.DepositPage;
import java.util.Map;

public class DepositPageSteps {
	private DepositPage dp = new DepositPage();

	@When("Выбрать – {string}")
	public void chooseCurrency(String currencyName) {
		dp.chooseCurrency(currencyName);
	}

	@When("Заполняются поля:")
	public void fillFields(DataTable fields) {
		Map<String, String> simple = fields.asMap(String.class, String.class);
		simple.forEach((field, value) -> dp.fillFields(field, value));
	}

	@When("Отметить – Ежемесячная капитализация")
	public void clickCapitalization() {
		dp.clickCapitalization();
	}

	@When("Выполнена проверка значений:")
	public void checkValues(DataTable values) {
		Map<String, String> simple = values.asMap(String.class, String.class);
		simple.forEach((field, value) -> dp.checkFields(field, value));
	}
}

