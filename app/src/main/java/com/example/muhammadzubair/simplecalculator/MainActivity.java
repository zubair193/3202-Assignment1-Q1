package com.example.muhammadzubair.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // views reference
    private TextView titleTextView;
    private Button addButton ,clearButton ,openCalculatorActivity;
    private EditText inputEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //calling method of super class
        super.onCreate(savedInstanceState);
        // set View for for Activity
        setContentView(R.layout.activity_main);

        // initializing the views refernce with views object from xml
        titleTextView= findViewById(R.id.title);
        addButton= findViewById(R.id.add);
        clearButton= findViewById(R.id.clear);
        inputEditText =findViewById(R.id.input);
        openCalculatorActivity =findViewById(R.id.openCalculator);


        // click listener for button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inputEditText.getText().toString().trim().length() == 0){
                    Toast.makeText(MainActivity.this , "Enter Text" , Toast.LENGTH_SHORT).show();
                    return;
                }

                if(inputEditText != null){
                    if(titleTextView !=null){
                        titleTextView.setText(inputEditText.getText().toString());
                    }
                }

            }
        });

        // click listener for button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inputEditText.getText().toString().trim().length() == 0){

                    if(titleTextView.getText().toString().length() != 0){
                        titleTextView.setText("");
                    }

                    Toast.makeText(MainActivity.this , "No Text To Clear" , Toast.LENGTH_SHORT).show();
                    return;
                }

                if(titleTextView !=null){
                    titleTextView.setText("");
                }

                if(inputEditText != null){
                    inputEditText.setText("");
                }
            }
        });

        openCalculatorActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this , CalculatorActivity.class));
            }
        });



    }//end of onCreate

}
