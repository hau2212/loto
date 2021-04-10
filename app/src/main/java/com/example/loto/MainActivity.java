package com.example.loto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView newText;
    EditText edit11, edit22;
    Button click1, click2, click3;
    String layEdit1 = "";
    String layEdit2 = "";
    Random random = null;
    String ketQua = "";
    List<Integer> mArrlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit11 = findViewById(R.id.edit1);
        edit22 = findViewById(R.id.edit2);
        click1 = findViewById(R.id.button1);
        newText = findViewById(R.id.textView1);
        click2 = findViewById(R.id.button2);
        click3 = findViewById(R.id.button3);

        mArrlist = new ArrayList<>();

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello();
                int sMin = Integer.parseInt(layEdit1);
                int sMax = Integer.parseInt(layEdit2);

                if (sMin >= sMax) {
                    sMax = sMin + 1;
                }

                edit22.setText(String.valueOf(sMax));
                mArrlist.clear();
                for (int i = sMin; i <= sMax; i++) {
                    mArrlist.add(i);

                }
                Toast.makeText(MainActivity.this, mArrlist.size(), Toast.LENGTH_SHORT).show();
                disable(click2);

            }
        });



        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



//        edit22.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    hello();
//                    int sMin = Integer.parseInt(layEdit1);
//                    int sMax = Integer.parseInt(layEdit2);
//
//                    if (sMin>= sMax) {
//                        sMax = sMin + 1;
//                    }
//
//                    //edit22.setText(String.valueOf(sMax));
//
//                    random = new Random();
//                    int valueRandom = random.nextInt(sMax - sMin + 1) + sMin;
//
//                    ketQua += valueRandom + " - ";
//
//                    newText.setText(ketQua);
//
//
//                }
//
//
//                return true;
//
//            }
//
//        });


    }

    private void enableView(View view){
        view.setEnabled(true);
    }
    private void disable(View view){
        view.setEnabled(false);
    }



    private void hello() {
        layEdit1 = edit11.getText().toString();
        layEdit2 = edit22.getText().toString();

        if (layEdit1.isEmpty() || layEdit2.isEmpty()) {
            Toast.makeText(MainActivity.this, "chua du", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}