package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by swapn on 16-07-2017.
 */

public class ALoginActivity extends AppCompatActivity {
    Button alogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alogin);

        alogin=(Button) findViewById(R.id.aloginbtn);

        alogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ALoginActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });






    }
}
