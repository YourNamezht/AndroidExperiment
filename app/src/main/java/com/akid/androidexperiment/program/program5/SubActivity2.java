package com.akid.androidexperiment.program.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akid.androidexperiment.R;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        setTitle(R.string.program5_2_child1);

        Button btnReturn = (Button)findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

    }

}

