package pageSteps;


import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
	HomePage hp = new HomePage();

	@When("Перейти в меню – {string}")
	public void openDeposit(String optionName){
		hp.chooseDeposit(optionName);
	}
}
