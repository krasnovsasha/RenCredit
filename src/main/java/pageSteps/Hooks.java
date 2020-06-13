package pageSteps;

import baseSettings.DriverSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void start() {
		DriverSettings.setUp();
	}

	@After
	public void finish() {
		DriverSettings.tearDown();
	}
}
