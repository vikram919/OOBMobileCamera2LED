package de.unirostock.de.oobmobilecamera2led;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected static String BLINK_FREQUENCY = "blinkFrequency";
    protected static String KEY_LENGTH = "keyLength";
    EditText editTextBlink;
    EditText editTextKeyLen;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextBlink = (EditText) findViewById(R.id.edit_text_blink);
        editTextKeyLen = (EditText) findViewById(R.id.edit_text_keyLength);
        textView = (TextView) findViewById(R.id.errorEntry);
    }

    public void startCamera(View view){
        int freq = Integer.parseInt(editTextBlink.getText().toString());
        int keyLength = Integer.parseInt(editTextKeyLen.getText().toString());
        if(0==freq || freq>200){
            textView.setVisibility(View.VISIBLE);
        } else {
            if(textView.getVisibility() ==  View.VISIBLE){
                textView.setVisibility(View.INVISIBLE);
            }
            // start camera
            Intent intent = new Intent(this,CameraActivity.class);
            intent.putExtra(BLINK_FREQUENCY, freq);
            intent.putExtra(KEY_LENGTH, keyLength);
            startActivity(intent);
        }
    }
}
