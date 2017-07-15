package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by swapn on 16-07-2017.
 */

public class VLoginActivity extends AppCompatActivity {
    Button signupbtn, loginbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlogin);

        signupbtn=(Button) findViewById(R.id.signupbtn);
        loginbtn=(Button) findViewById(R.id.loginbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VLoginActivity.this,VRegActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VLoginActivity.this,VolunteerActivity.class);
                startActivity(intent);
            }
        });



    }
}
