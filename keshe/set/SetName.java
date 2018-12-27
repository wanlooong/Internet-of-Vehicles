package com.example.administrator.keshe.set;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.keshe.R;
import com.example.administrator.keshe.modle.Person;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class SetName extends Activity {
    EditText edit_name;
    String name;
    Button chat;

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.set_name);
        edit_name = findViewById(R.id.edit_nick);
      /* edit_sex = (EditText) findViewById(R.id.edit_sex); */
        chat = findViewById(R.id.btn_chat);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit_name.getText().toString();
                //    sex=edit_sex.getText().toString();
                Person newUser = new Person();
                newUser.setName(name);
                //      newUser.setSex(sex);
                BmobUser bmobUser = BmobUser.getCurrentUser(mContext);
                newUser.update(mContext, bmobUser.getObjectId(), new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        toast("修改昵称成功:");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        toast("修改昵称失败:" + msg);
                    }
                });
            }
        });
    }

    public void toast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

}
