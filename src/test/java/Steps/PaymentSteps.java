package Steps;

import Connector.DriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.payment.Pages.PaymentPage;

public class PaymentSteps {
    PaymentPage paymentPage;

    public PaymentSteps() {
        paymentPage = new PaymentPage(DriverSetup.driver);
    }

    @Given("^user open the payment web, user change currency to (.*)")
    public void user_change_currency_to_bhd(String currency) {
        paymentPage.selectCurrency(currency);
    }

    @When("^user change scope to (.*)")
    public void user_change_scope_to_authenticated_token(String scope) {
        paymentPage.selectScope(scope);
    }

    @Then("^user fills card number (.*)")
    public void user_fills_card_number(String cardNumber) {
        paymentPage.enterCardNumber(cardNumber);
    }

    @And("^user fills card expiry date (.*)")
    public void user_fills_card_expiry_date(String cardExpiryDate) {
        paymentPage.enterCardExpiryDate(cardExpiryDate);
    }

    @And("^user fills card cvv (.*)")
    public void user_fills_card_CVV(String cardCVV) {
        paymentPage.enterCardCVV(cardCVV);
    }

    @Then("user click on create token button")
    public void user_click_on_create_token_button() {
        paymentPage.clickOnGenerateTokenButton();
    }

    @And("user click on submit")
    public void user_click_on_submit() {
        paymentPage.clickOnSubmitButton();
    }

    @When("user click on response button")
    public void user_click_on_response_button() {
        paymentPage.clickOnResponseButton();
    }

    @Then("print the response")
    public void print_the_response() {
        paymentPage.printTheResponse();
    }

}
