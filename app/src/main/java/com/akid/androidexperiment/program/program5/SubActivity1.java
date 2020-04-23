package com.akid.androidexperiment.program.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akid.androidexperiment.R;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        setTitle(R.string.program5_2_child1);

        final EditText editText = (EditText)findViewById(R.id.edit);
        Button btnOK = (Button)findViewById(R.id.btn_ok);
        Button btnCancel = (Button)findViewById(R.id.btn_cancel);

        btnOK.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                String uriString = editText.getText().toString();
                Uri data = Uri.parse(uriString);

                Intent result = new Intent(null, data);
                setResult(RESULT_OK, result);
                finish(); // 结束当前活动罪恶的一生
            }
        });

        btnCancel.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Log.e("传入的值:","为啥没有执行");
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}
