package com.example.administrator.keshe.keshe;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.keshe.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SayHelloActivity extends Activity {
    private TextView textView;
    private EditText editText;
    private Button button;

    private Socket socket;
    private BufferedWriter bWriter;//输出流，发送、写入信息
    private BufferedReader bReader;//输入流，接受、读取信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_hello);

        textView = findViewById(R.id.message);
        editText = findViewById(R.id.edit_msg);
        button = findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        connect();
    }

    private void connect() {
        new AsyncTask<Void, String, Void>() {
            //在主线程中执行，不能用来初始化socket
            protected void onPreExecute() {
            }
            protected Void doInBackground(Void[] params) {
                try {
                    socket = new Socket("127.0.0.1", 9999);
                    bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    publishProgress("connect success");
                } catch (IOException e) {
                    Log.e("connect error", "error");
                }
                String s;
                //readLine()是一个阻塞函数，当没有数据读取时，就一直会阻塞在那，而不是返回null
                //接受信息
                try {
                    while ((s = bReader.readLine()) != null) {
                        publishProgress(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            protected void onProgressUpdate(String[] values) {
                if (values[0].equalsIgnoreCase("connect success")) {
                    Toast.makeText(SayHelloActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                } else {
                    textView.append("别人说" + values[0] + "\n");
                }
            }
        }.execute();
    }

    //发送信息
    private void send() {
        try {
            textView.append("我说：" + editText.getText().toString() + "\n");
            bWriter.write(editText.getText().toString() + "\n");
            bWriter.flush();
            editText.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
