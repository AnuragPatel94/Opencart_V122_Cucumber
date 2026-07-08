package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CheckOutSteps {

    @Given("the user is on the shopping cart page")
    public void the_user_is_on_the_shopping_cart_page() {
        System.out.println("User is on shopping cart page");
    }

    @Given("the product is added to the cart with the correct price")
    public void the_product_is_added_to_the_cart_with_the_correct_price() {
        System.out.println("Product added to cart with correct price");
    }

    @When("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        System.out.println("Checkout button clicked");
    }

    @Then("the user should be redirected to the payment page")
    public void the_user_should_be_redirected_to_the_payment_page() {
        System.out.println("User redirected to payment page");
    }

    @Then("the payment page should display the order summary")
    public void the_payment_page_should_display_the_order_summary() {
        System.out.println("Order summary displayed");
    }
}
