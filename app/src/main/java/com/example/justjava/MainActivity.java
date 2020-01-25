/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
//import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 5;

    /**
     * this method runs on the app start, or creation
     * and calls the setContentView method that uses the
     * layout resource R.layout.activity_main which is the xml
     * layout for our app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkBox = findViewById(R.id.whippedCreamCheckBox);
        //initialize the variable for the checkBox that I will be referencing
        boolean hasWhippedCream = checkBox.isChecked();
        //initialize the value of the check state of that checkBox
        // the return type of "isChecked" is type boolean;
        //the variable name is hasWhippedCream
        //to check the state of the checkBox, call the method .isChecked on it
        //checkBox.isChecked() returns true or false, stored in the boolean type variable
        //hasWhippedCream;
       int price = calculatePrice();
       //in order to use that true or false value stored in boolean hasWhippedCream
        //in the createOrderSummary method, you must pass that boolean variable
        //to the createOrderSummary method as an additional argument, see below;
        //you must also change the createOrderSummary method to expect two arguments
        //and must pass the right arguments in the right order;
        //now that we have added a second checkbox, we had a third input parameter
        //to the createOrderSummary method to pass that variable to that method.
        //Then below, in that method we have to change the method signature
        //to look for and accept the third value. But you must tell it what
        //type of value it should accept, telling it in the method signature;
        CheckBox chocCheckBox = findViewById(R.id.chocolateCheckBox);
        boolean hasChocolate =chocCheckBox.isChecked();
        //the next line initializes a variable of type String called priceMessage
        //this variable is set to the return value of createOrderSummary
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        //the next line calls the displayMessage method with the input parameter
        //of priceMessage, a string comprised of return value of the createOrderSummary
        //method.
        displayMessage(priceMessage);
    }

    /**
     * this method creates a message that uses price and quantity and returns a string
     * @param price of the order
     * @param hasWhippedCream boolean checkstate of the whippedCreamCheckBox
     * @param hasChocolate boolean value of isChecked for chocolateCheckBox
     * @return priceMessage
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate) {
        //this method is expecting the variables /price/ and /hasWhippedCream
        // and /hasChocolate;
        //these parameters were passed to the variable in the SubmitOrder method;
        //this method is being called solely in the SubmitOrder method.
        //the second variable name does not have to match the variable name
        //that was passed into arguments previously;
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal :$" + price;
        priceMessage += "\nHas Whipped Cream: " + hasWhippedCream;
        priceMessage += "\nHas Chocolate Topping: " + hasChocolate;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**this method should increase the quanitiy when the plus button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**this method decreases the quantity, or should once it is fixed, when the minus button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setTextSize(number + 14);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     * @param message expects a String that will be displayed when the method is called
     */
    private void displayMessage(String message) {
        //this method is private, only to be used in this class
        //void means that the method does not return any value
        //the name of the method is displayMessage
        //the input parameter of this method is a string (the variable message
        //is different than the name of the variable passed to it
        //but that doesn't matter, only that the String passed to it now has the
        //variable name /message
        //the TextView named by findViewById is set to the variable name orderSummary
        TextView orderSummary = findViewById(R.id.order_summary_text_view);
        //then the method .setText is called on that TextView /orderSummary
        //and the input parameter is the String /message that was passed into the
        //method
        orderSummary.setText(message);
    }

    /**
     * this method calculates the price of the order, storing that value in the
     * @return price is an int = quantity of cups * pricePerCup
     */
    private int calculatePrice(){
        int price = quantity * pricePerCup;
        return price;
    }
}