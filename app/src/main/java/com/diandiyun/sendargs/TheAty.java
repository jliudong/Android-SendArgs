package com.diandiyun.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TheAty extends AppCompatActivity {

    private TextView tv;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_aty);

        Intent i = getIntent();
//        Bundle bundle = i.getBundleExtra("data");
//
        tv = (TextView) findViewById(R.id.tv);
////        tv.setText(i.getStringExtra("data"));
//        tv.setText(String.format("name %s age %d", bundle.getString("name"), bundle.getInt("age")));
//        User user = (User) i.getSerializableExtra("user");
        User user = i.getParcelableExtra("user");
        tv.setText((String.format("name %s age %d", user.getName(), user.getAge())));

        et = (EditText) findViewById(R.id.editText);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", et.getText().toString());
                setResult(1, i);
                finish();
            }
        });
    }
}
