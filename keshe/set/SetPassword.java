package com.example.administrator.keshe.set;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.keshe.R;
import com.example.administrator.keshe.modle.Person;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;


/**
 * Created by Nikcn on 2016/6/1.
 */
public class SetPassword extends Activity {
    EditText edit_name;
    EditText edit_sex;
    String name;
    String sex;
    Button chat;

    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.set_password);
        edit_name = (EditText) findViewById(R.id.edit_nick);
        edit_sex = (EditText) findViewById(R.id.edit_sex);
        chat=(Button)findViewById(R.id.btn_chat);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setpassword();
            }
        });
    }

    public  void setpassword(){
        String password = edit_name.getText().toString();
        String comfirmPsd = edit_sex.getText().toString();


        if (TextUtils.isEmpty(password)) {
            toast("密码不能为空");
            return;
        }
        if (!comfirmPsd.equals(password)) {
            toast("确认密码与密码不同");
            return;
        }

        Person newUser = new Person();
        newUser.setPassword(password);
        BmobUser bmobUser = BmobUser.getCurrentUser(mContext);



        newUser.update(mContext,bmobUser.getObjectId(),new UpdateListener() {
            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub
                toast("修改密码成功");
            }
            @Override
            public void onFailure(int code, String msg) {
                // TODO Auto-generated method stub
                toast("修改密码失败:" + msg);
            }
        });

    }
    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

}
