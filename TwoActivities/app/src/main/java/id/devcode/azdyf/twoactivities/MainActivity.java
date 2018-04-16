package id.devcode.azdyf.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "id.devcode.azdyf.twoactivities.extra.MESSAGE";

    private EditText etMessage;
    private TextView tvMsgReply, tvHeaderReply;

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = (EditText) findViewById(R.id.et_message);
        tvHeaderReply = (TextView) findViewById(R.id.text_header_reply);
        tvMsgReply = (TextView) findViewById(R.id.text_reply);


    }

    public void sendMessage(View view) {
        Log.d(TAG, "Button Clicked");

        String message = etMessage.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                tvMsgReply.setVisibility(View.VISIBLE);
                tvHeaderReply.setVisibility(View.VISIBLE);
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                tvMsgReply.setText(reply);
            }
        }
    }
}
