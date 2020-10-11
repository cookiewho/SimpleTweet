package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ComposeActivity extends AppCompatActivity {

    public static final int MAX_TWEET_LENGTH = 240;

    TextInputLayout TILCompose;
    EditText etCompose;
    Button btnTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        TILCompose = findViewById(R.id.TILCompose);
        TILCompose.setCounterMaxLength(MAX_TWEET_LENGTH);
        etCompose = findViewById(R.id.etCompose);

        btnTweet = findViewById(R.id.btnTweet);

        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tweetContent = etCompose.getText().toString();
                if(tweetContent.isEmpty()){
                    Toast.makeText(ComposeActivity.this,"Tweet cannot be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (tweetContent.length() > MAX_TWEET_LENGTH){
                    Toast.makeText(ComposeActivity.this,"Tweet is too long", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(ComposeActivity.this,"Tweet has been posted", Toast.LENGTH_LONG).show();
            }
        });

    }
}