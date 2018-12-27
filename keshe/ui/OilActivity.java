package com.example.administrator.keshe.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.keshe.R;
import com.example.administrator.keshe.oil.EncodingHandler;
import com.example.administrator.keshe.oil.OilAddVehcle;
import com.google.zxing.WriterException;

import cn.bmob.v3.BmobUser;
;

/**
 * Created by Nikcn on 2016/5/10.
 */
public class OilActivity extends Activity {
    private TextView User;
    private RelativeLayout AddVehcle;

    TextView number;
    TextView oilclass;
    TextView vehcleclass;
    EditText Oilnumber;
    private ImageView qrImgImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_oil);

        Button generateQRCodeButton = (Button) this.findViewById(R.id.btn_login);
        number=(TextView)findViewById(R.id.number);
        oilclass=(TextView)findViewById(R.id.oilclass);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        Oilnumber=(EditText)findViewById(R.id.Oilnumber);

        AddVehcle=(RelativeLayout)findViewById(R.id.layout_info);
        AddVehcle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add=new Intent(OilActivity.this,OilAddVehcle.class);
                startActivity(add);
            }
        });





        final String vehclenumbertext = (String) BmobUser.getObjectByKey(this, "vehclenumber1");
        final String oilclasstext = (String) BmobUser.getObjectByKey(this, "oilclass1");

        if(vehclenumbertext==null){
            number.setText("车牌：");
        }
        else
        {
            number.setText("车牌："+vehclenumbertext);
        }

        if (oilclasstext== null) {
            oilclass.setText("加油类型：");
        }
        else{
            oilclass.setText("加油类型："+oilclasstext);
        }


        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (vehclenumbertext.equals(null) || oilclasstext.equals(null) || Oilnumber.getText().toString().equals("")){
                    Toast.makeText(OilActivity.this, "请输入车牌，油型，加油数目", Toast.LENGTH_SHORT).show();
                }
                else{
                try {
                    String contentString = "车牌:"+vehclenumbertext +"   油型："+oilclasstext+"   加油数目："+ Oilnumber.getText().toString();
                    if (!contentString.equals("")) {
                        //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                        Bitmap qrCodeBitmap = EncodingHandler.createQRCode(contentString, 500);
                        qrImgImageView.setImageBitmap(qrCodeBitmap);
                        Toast.makeText(OilActivity.this, "二维码已生成，请前往加油站扫描此二维码", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(OilActivity.this, "Text can not be empty", Toast.LENGTH_SHORT).show();
                    }

                } catch (WriterException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }}
            }

        });







    }
}
