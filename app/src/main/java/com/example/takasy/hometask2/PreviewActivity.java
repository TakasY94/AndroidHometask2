package com.example.takasy.hometask2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    public static final String MESSAGE = "MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.emailButton);
        final String[] address = {"test@gmail.com"};
        final String subject = "Hello Android!";

        final String receivedMessage = getIntent().getStringExtra(MESSAGE);
        textView.setText(receivedMessage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, receivedMessage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    public static void start(Activity activity, String text) {
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(MESSAGE, text);
        activity.startActivity(intent);
    }
}
