package myStore.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myStore.abilities.NavigateTo;
import myStore.actions.GoToSection;
import myStore.actions.LogsInWith;
import myStore.constants.Constants;
import myStore.questions.MyAccountPage;
import myStore.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static org.hamcrest.CoreMatchers.equalTo;

public class StepDefinitions {

    @Given("{actor} open my store site")
    public void openSite(Actor actor){
        actor.wasAbleTo(NavigateTo.myStoreHomePage());
    }

    @When("{actor} logs in with user {string} and password {string}")
    public void LogsInWith(Actor actor, String username, String password){
        actor.attemptsTo(
                LogsInWith.credentials(username, password)
        );
    }

    @When("{actor} go to my account section")
    public void goToAccountSection(Actor actor){
        actor.attemptsTo(GoToSection.myAccount());
    }

    @When("{actor} wait for login to be loaded")
    public void waitForLoadedResults(Actor actor){
        actor.attemptsTo(WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(30).seconds());
    }

    @Then("{actor} should see log in status correctly")
    public void shouldSeeLoginStatus(Actor actor){
        actor.should(seeThat("Page", MyAccountPage.loginStatus(), equalTo(Constants.LOGIN_STATUS_TITLE)));
    }

}
