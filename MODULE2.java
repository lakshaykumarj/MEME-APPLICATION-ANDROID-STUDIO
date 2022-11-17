package com.example.memegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class MODULE2 extends AppCompatActivity {
    TextInputEditText ed1;
    Button bn,bn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        ed1=(TextInputEditText)findViewById(R.id.yeartext);
        bn=findViewById(R.id.SUBMIT);
        bn1=findViewById(R.id.BACK);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MODULE2.this.finish();
            }
        });
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(ed1.getText().toString()))
                {
                    Toast.makeText(MODULE2.this, "Enter values",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(MODULE2.this,modulememe.class);
                    i.putExtra("query", ed1.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}
