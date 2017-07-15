package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by swapna on 16-07-2017.
 */

public class MainActivity extends AppCompatActivity {
    Button stubtn,admbtn,volbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vreg);

        stubtn=(Button)findViewById(R.id.stud_btn);
        admbtn=(Button)findViewById(R.id.adm_btn);
        volbtn=(Button)findViewById(R.id.vol_btn);



        stubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SSignUpActivity.class);
                startActivity(intent);
            }
        });

        admbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });

        volbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VLoginActivity.class);
                startActivity(intent);
            }
        });




    }

}
