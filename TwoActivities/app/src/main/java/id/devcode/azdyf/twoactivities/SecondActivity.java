package id.devcode.azdyf.twoactivities;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "id.devcode.azdyf.twoactivities.extra.REPLY";
    TextView tvReceived;
    EditText etReply;

    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        tvReceived = (TextView) findViewById(R.id.text_message);
        tvReceived.setText(message);

        etReply = (EditText) findViewById(R.id.et_reply);
    }

    public void replyMessage(View view) {
        Log.d(TAG, "Button Clicked!");
        String reply = etReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
