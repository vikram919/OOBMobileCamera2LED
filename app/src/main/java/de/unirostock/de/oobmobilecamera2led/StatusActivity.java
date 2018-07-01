package de.unirostock.de.oobmobilecamera2led;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatusActivity extends AppCompatActivity {

    private static final String oobKey = "";
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

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            /*
            Listens for error messages if BACnetService fails,
            starts status intent early inform user about the error.
            */
            if (intent.getAction().equals(CameraActivity.OOB_KEY_SIGNAL)){
                String key = intent.getStringExtra(CameraActivity.OOB_KEY_SIGNAL_PAYLOAD);
                if(key.equals(oobKey)){
                    okImage.setVisibility(View.VISIBLE);
                    textView.setText("Success!");
                }else{
                    notOkImage.setVisibility(View.VISIBLE);
                    textView.setTextColor(Color.RED);
                    textView.setText("Test Failed!");
                }
            }
        }
    };
}
