package com.example.administrator.keshe.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.administrator.keshe.R;

import cn.bmob.v3.BmobUser;

/**
 * Created by Nikcn on 2016/6/1.
 */
public class FixActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fix);



        TextView number1;
        TextView oilclass1;
        TextView vehcleclass1;
        number1=(TextView)findViewById(R.id.number1);
        oilclass1=(TextView)findViewById(R.id.oilclass1);
        vehcleclass1=(TextView)findViewById(R.id.vehcleclass1);



        String vehclenumbertext1 = (String) BmobUser.getObjectByKey(this, "vehclenumber1");
        String vehcleclasstext1 = (String) BmobUser.getObjectByKey(this, "vehcleclass1");
        String oilclasstext1 = (String) BmobUser.getObjectByKey(this, "oilclass1");



        if(vehclenumbertext1==null){
            number1.setText("车牌：未设置");
        }
        else
        {
            number1.setText("车牌："+vehclenumbertext1);
        }


        if(vehcleclasstext1==null){
            vehcleclass1.setText("车型：未设置");
        }
        else{
            vehcleclass1.setText("车型："+vehcleclasstext1);
        }
        if (oilclasstext1== null) {
            oilclass1.setText("油型：未设置");
        }
        else{
            oilclass1.setText("油型："+oilclasstext1);
        }
    }
}
