package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by swapna on 16-07-2017.
 */

public class ALoginActivity extends AppCompatActivity {
    Button alogin;
    EditText e_aname,e_apassword;
    String name, password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alogin);

        e_aname=(EditText) findViewById(R.id.et_aname);
        e_apassword=(EditText) findViewById(R.id.et_apassword);
        alogin=(Button) findViewById(R.id.aloginbtn);



        alogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=e_aname.getText().toString();
                password=e_apassword.getText().toString();

                if(name.equals("admin") && password.equals("admin")){
                    Intent intent = new Intent(ALoginActivity.this,AdminActivity.class);
                    startActivity(intent);

                }

            }
        });












    }
}
