package de.unirostock.de.oobmobilecamera2led;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class StatusActivity extends AppCompatActivity {

    private static final String oobKey = "1001100110110110011001101100110";
    ImageButton okImage;
    ImageButton notOkImage;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        okImage = (ImageButton) findViewById(R.id.ok);
        notOkImage = (ImageButton) findViewById(R.id.notOk);
        textView = (TextView) findViewById(R.id.text);
        String key = getIntent().getStringExtra(CameraActivity.OOB_KEY_SIGNAL_PAYLOAD);
        Log.d("StatusActivity", getIntent().getStringExtra(CameraActivity.OOB_KEY_SIGNAL_PAYLOAD));
        if (key.equals(oobKey)) {
            okImage.setVisibility(View.VISIBLE);
            textView.setText("Success!");
            Log.d("StatusActivity", "Success!");
        } else {
            notOkImage.setVisibility(View.VISIBLE);
            textView.setTextColor(Color.RED);
            textView.setText("Test Failed!");
            Log.d("StatusActivity", "Test Failed!");
        }

    }
}
