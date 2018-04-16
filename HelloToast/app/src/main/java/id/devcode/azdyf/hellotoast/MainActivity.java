package id.devcode.azdyf.hellotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvShowCount;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowCount = (TextView) findViewById(R.id.tv_show_count);
    }

    public void showToast(View view) {
        // Create a toast show it
        Toast toast = Toast.makeText(this, "Hello Toast", Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (tvShowCount != null) {
            tvShowCount.setText(Integer.toString(mCount));
        }
    }
}
