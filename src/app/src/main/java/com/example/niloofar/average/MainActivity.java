package com.example.niloofar.average;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer>unitList=new ArrayList<>();
    ArrayList<Float>scoreList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addScore(View view){

        EditText unitObj=findViewById(R.id.txt_vahed);
        EditText scoreObj=findViewById(R.id.txt_nomre);
        int unit=Integer.parseInt(unitObj.getText().toString());
        float score= Float.parseFloat(scoreObj.getText().toString());

        unitList.add(unit);
        scoreList.add(score);

        TextView avgTObj=findViewById(R.id.txv_avg);
        TextView termStatusObj=findViewById(R.id.txv_status);

        float finalAvg=calcAvg();

        avgTObj.setText(String.valueOf(calcAvg()));
        termStatusObj.setText(avgStatus(calcAvg()));


    }
    public float calcAvg(){
        float avg=0;
        float totalScore=0;
        float totalUnit=0;
        for (int i = 0; i <scoreList.size() ; i++) {
            totalScore+=scoreList.get(i)*unitList.get(i);
            totalUnit+=unitList.get(i);
        }
        return totalScore/totalUnit;
    }
    public String avgStatus(float avg){

         String label="mardod";
         if(avg>=17){
             label="momtaz";
         }else if(avg>=12 && avg<17){
             label="aadi";
         }else if(avg>=10 && avg<12){
             label="mashroot";
         }

         return label;
    }
}
