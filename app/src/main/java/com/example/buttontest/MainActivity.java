package com.example.buttontest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    RadioGroup radioGroup1, radioGroup2;
    CheckBox checkbox11, checkbox12, checkbox13, checkbox14;
    CheckBox checkbox21, checkbox22, checkbox23, checkbox24;
    ToggleButton toggleButton;
    Button resultButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);

        checkbox11 = findViewById(R.id.checkbox11);
        checkbox12 = findViewById(R.id.checkbox12);
        checkbox13 = findViewById(R.id.checkbox13);
        checkbox14 = findViewById(R.id.checkbox14);

        checkbox21 = findViewById(R.id.checkbox21);
        checkbox22 = findViewById(R.id.checkbox22);
        checkbox23 = findViewById(R.id.checkbox23);
        checkbox24 = findViewById(R.id.checkbox24);

        toggleButton = findViewById(R.id.toggleButton);
        resultButton = findViewById(R.id.buttonResult);

        resultText = findViewById(R.id.resultText);

        resultButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    @SuppressLint("SetTextI18n")
                    public void onClick(View v)
                    {
                        if (radioGroup1.getCheckedRadioButtonId() == R.id.radio2){
                            score += 1;
                        }
                        if (checkbox11.isChecked() && checkbox13.isChecked() && checkbox14.isChecked()){
                            score += 1;
                        }
                        if (radioGroup2.getCheckedRadioButtonId() == R.id.radio23){
                            score += 1;
                        }
                        if (checkbox21.isChecked() && checkbox22.isChecked()){
                            score += 1;
                        }
                        if (toggleButton.isChecked()) {
                            score += 1;
                        }
                        double percentage = (score * 100.0) / 5;
                        if (percentage >= 90) {
                            resultText.setText("Ваш результат: " + score + "/5. Оценка - 5");
                            resultText.setTextColor(getColor(R.color.grade_5));
                        } else if (percentage >= 70) {
                            resultText.setText("Ваш результат: " + score + "/5. Оценка - 4");
                            resultText.setTextColor(getColor(R.color.grade_4));
                        } else if (percentage >= 50) {
                            resultText.setText("Ваш результат: " + score + "/5. Оценка - 3");
                            resultText.setTextColor(getColor(R.color.grade_3));
                        } else {
                            resultText.setText("Ваш результат: " + score + "/5. Оценка - 2");
                            resultText.setTextColor(getColor(R.color.grade_2));
                        }
                    }
                }
        );
    }
    }
