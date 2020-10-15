package com.example.layoutex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3,cb4;
    private String str = "您选择了";
    private String city ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_bj);
        cb2 = findViewById(R.id.cb_sh);
        cb3 = findViewById(R.id.cb_sz);
        cb4 = findViewById(R.id.cb_gz);

        CompoundButton.OnCheckedChangeListener listener= new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
                if(isChecked)
                {
                    if(!city.equals(""))city += ",";
                    city += cb.getText();
                }
                else
                {
                    int index = city.indexOf(cb.getText().toString());
                    int len = cb.getText().length();
                    if(city.length()==len)
                    {
                        city="";
                    }
                    else
                    {
                        if(index!=0)
                        {
                            city = city.substring(0, index - 1) + city.substring(index + len);
                        }
                        else
                        {
                            city = city.substring(len+1);
                        }
                    }
                }
                Toast.makeText(MainActivity.this, str+city, Toast.LENGTH_SHORT).show();
            }
        };

        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);
        cb4.setOnCheckedChangeListener(listener);


    }
}