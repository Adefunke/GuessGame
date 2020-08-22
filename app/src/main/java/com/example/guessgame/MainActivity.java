package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //todo 1: set the range of value to be guessed to 0 and 500.

    //todo 2: there are some grammatical errors in the message showing for R.string.think_higher
    //  and R.string.think_lower. Trace where the values were defined and correct them.
    //  Hint: You can locate it by clicking on 'app' on the left handside dropdown, then click on
    //  'res', then click on 'values', then click on string.xml. You should see the strings make
    //  the appropriate corrections. For the strings you are correcting I left a comment above them.

    //todo 3: add a condition in the click function to show a message when the guess is less than
    // the minimum range. E.g. the current minimum value is 0 and I guess -1; the message that
    // should be seen is: "Seriously!!, The game is meant for you to guess between 0 and 500,
    // we both know -1 is less than 0."

    // todo 4: add a condition in the click function to show a message when the guess is greater than
    //  the maximum range. E.g. the current maximum value is 500 and I guess 600; the message that
    //  should be seen is: "Seriously!!, The game is meant for you to guess between 0 and 500,
    //  we both know 600 is greater than 500."

    // todo 5: just like we have a variable called int result, we need a variable called int noOfGuesses.
    //  It keeps track of the number times the person playing the game has guessed. i.e. you will be
    //  iterating the wrong guesses.

    // todo 6: if you run your code, the prompt message shows 1 to 100 not 0 to 500, fix it.

    int result;

    // this is the method that randomly guesses the value between 0 and 500.
    static int getRandomNumber(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // toast is a method that shows pop up for a while. Therefore, the string it takes in
    // will determine the message you see.
    public void makeToast(int str) {
        Toast.makeText(MainActivity.this, getText(str), Toast.LENGTH_SHORT).show();
    }

    public void clickFunction(View view) {
        // the value you input will show as a string but what is expected is an integer.
        // Therefore, there is need to convert it to a number. This is done by using method
        // Integer.parseInt. So whatever string is put into will be returned as a number.
        // You can press down your CTRL button, hover on parseInt and click on it to see them method.
        EditText variable = findViewById(R.id.editId);
        int userGuessing = Integer.parseInt(variable.getText().toString());
        if (userGuessing < result) {
            makeToast(R.string.think_higher);
        } else if (userGuessing > result) {
            makeToast(R.string.think_lower);
        } else {
            makeToast(R.string.congrats);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
    }
}