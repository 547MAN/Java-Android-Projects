package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Section to define input boxes,clear text box and answer box:
        final EditText inputBoxA=findViewById(R.id.first_numb_input);
        final EditText inputBoxB=findViewById(R.id.second_numb_input);
        final TextView answerBox=findViewById(R.id.answer_box);


        //Section to clear the user inputs + clear answer box

        final Button clr_btn=findViewById(R.id.clear_input_btn);

        clr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputBoxA.setText("");
                inputBoxB.setText("");
                answerBox.setText("Answer");

            }
        });

        //section to scale the buttons on click and to perform calculation according to the button
        //Plus button---------------
        final ImageButton plus_button=findViewById(R.id.img_btn_pluss_sign);
        final float originalScalePluss= plus_button.getScaleX();

        plus_button.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    plus_button.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
                }else if(event.getAction()==MotionEvent.ACTION_UP) {
                    plus_button.animate().scaleX(originalScalePluss).scaleY(originalScalePluss).setDuration(100).start();

                    //Calculation Logic:
                    String valueA= inputBoxA.getText().toString();
                    String valueB=inputBoxB.getText().toString();

                    if (!valueA.isEmpty() && !valueB.isEmpty()) {
                        double sum =Double.parseDouble(valueA) + Double.parseDouble(valueB);

                        String formattedSum=String.format("%.4f",sum);
                        answerBox.setText(""+sum);
                    }



                } return false;
            }
        });

        //Minus button---------------
        final ImageButton minus_button=findViewById(R.id.img_btn_minus_sign);
        final float originalScaleMinus= minus_button.getScaleX();

        minus_button.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    minus_button.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
                }else if(event.getAction()==MotionEvent.ACTION_UP) {
                    minus_button.animate().scaleX(originalScaleMinus).scaleY(originalScaleMinus).setDuration(100).start();

                    //Calculation Logic:
                    String valueA= inputBoxA.getText().toString();
                    String valueB=inputBoxB.getText().toString();

                    if (!valueA.isEmpty() && !valueB.isEmpty()) {
                        double sum =Double.parseDouble(valueA) - Double.parseDouble(valueB);

                        String formattedSum=String.format("%.4f",sum);
                        answerBox.setText(""+sum);
                    }


                } return false;
            }
        });

        //Multiply button---------------
        final ImageButton multiply_button=findViewById(R.id.img_btn_multiply_sign);
        final float originalScaleMultiply= multiply_button.getScaleX();

        multiply_button.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    multiply_button.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
                }else if(event.getAction()==MotionEvent.ACTION_UP) {
                    multiply_button.animate().scaleX(originalScaleMultiply).scaleY(originalScaleMultiply).setDuration(100).start();

                    //Calculation Logic:
                    String valueA= inputBoxA.getText().toString();
                    String valueB=inputBoxB.getText().toString();

                    if (!valueA.isEmpty() && !valueB.isEmpty()) {
                        double sum =Double.parseDouble(valueA) * Double.parseDouble(valueB);

                        String formattedSum=String.format("%.4f",sum);
                        answerBox.setText(""+sum);
                    }


                } return false;
            }
        });


        //Division button---------------
        final ImageButton division_button=findViewById(R.id.img_btn_division_sign);
        final float originalScaleDivision= division_button.getScaleX();

        division_button.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    division_button.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
                }else if(event.getAction()==MotionEvent.ACTION_UP) {
                    division_button.animate().scaleX(originalScaleDivision).scaleY(originalScaleDivision).setDuration(100).start();

                    //Calculation Logic:
                    String valueA= inputBoxA.getText().toString();
                    String valueB=inputBoxB.getText().toString();

                    if (!valueA.isEmpty() && !valueB.isEmpty()) {
                        double sum =Double.parseDouble(valueA) / Double.parseDouble(valueB);

                        String formattedSum=String.format("%.4f",sum);
                        answerBox.setText(""+sum);
                    }
                } return false;
            }
        });


    }


}