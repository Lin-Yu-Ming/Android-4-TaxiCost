package com.example.android_num4_texicost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.compute);
        button.setOnClickListener(Thetexi);
    }
    private View.OnClickListener Thetexi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            EditText Count = (EditText)findViewById(R.id.Distance);
            EditText Count1 = (EditText)findViewById(R.id.meter);
            EditText Count2 = (EditText)findViewById(R.id.AddMoney);

            int basic = 75;
            //距離
            double distance = Double.parseDouble(Count.getText().toString());
            double basicCount = Double.parseDouble(Count1.getText().toString());
            double addCost = Double.parseDouble(Count2.getText().toString());
            //費用計算
            double count = basic + ((distance / basicCount) * addCost);

            TextView cost = (TextView)findViewById(R.id.Cost);
            //里程低於250公尺時
            if (distance < 250){
                cost.setText("80 元");
            }//每250公尺時且費率加收5元
            else if(distance >= 250 && addCost >=5){
                cost.setText(nf.format(count) + "元");
            }
        }
    };
}