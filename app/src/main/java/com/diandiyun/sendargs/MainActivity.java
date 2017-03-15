package com.diandiyun.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TheAty.class);

//                i.putExtra("data", "diandiyun");

//                Bundle bundle = new Bundle();
//                bundle.putString("name", "xiaomi");
//                bundle.putInt("age", 2);
//                i.putExtra("data", bundle);

                i.putExtra("user", new User("ddy",2));
//                startActivity(i);

                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText("返回的数据是:"+data.getStringExtra("data"));
    }
}
