package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    int expectedPurchaseAmount = 0;

    @When("The user adds {string} product from {string} category")
    public void the_user_adds_product_from_category(String product, String category) {
        expectedPurchaseAmount += homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }

    @When("The user removes {string} chosen product from Cart Page")
    public void the_user_removes_chosen_product_from_cart_page(String removeProduct) {
        expectedPurchaseAmount -= cartPage.removeProduct(removeProduct);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);


    }

    @When("The user places order and captures and log amount")
    public void the_user_places_order_and_captures_and_log_amount() {
        cartPage.finishPurchase_logAmount();

    }

    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {

    }
}

