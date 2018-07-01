package de.unirostock.de.oobmobilecamera2led;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editbox);
        textView = (TextView) findViewById(R.id.errorEntry);
    }

    public void startCamera(View view){
        int freq = Integer.parseInt(editText.getText().toString());
        if(0==freq || freq>200){
            textView.setVisibility(View.VISIBLE);
        } else {
            if(textView.getVisibility() ==  View.VISIBLE){
                textView.setVisibility(View.INVISIBLE);
            }
            // start camera
        }
    }
}
