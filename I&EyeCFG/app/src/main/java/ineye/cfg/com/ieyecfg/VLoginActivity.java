package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by swapn on 16-07-2017.
 */

public class VLoginActivity extends AppCompatActivity {
    EditText e_vmob,e_vpass;
    String vmob,vpass;
    Button signupbtn, loginbtn;
    public static String url_reg="http://192.168.43.96/cfg_connection/login.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlogin);

        e_vmob=(EditText) findViewById(R.id.et_vmobile);
        e_vpass=(EditText) findViewById(R.id.et_vpassword);
        signupbtn=(Button) findViewById(R.id.vsignupbtn);
        loginbtn=(Button) findViewById(R.id.vloginbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VLoginActivity.this,VRegActivity.class);
                startActivity(intent);
            }
        });




    }

    public void loginVolunteer(View view) {

        String tag_string_req = "req_register";
        vmob = e_vmob.getText().toString();
        vpass = e_vpass.getText().toString();


        StringRequest strReq = new StringRequest(Request.Method.POST, url_reg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VLoginActivity.this, response, Toast.LENGTH_LONG).show();

                try {
                    JSONObject jObj = new JSONObject(response);

                    String value = jObj.getString("uid");

                    if (value.equalsIgnoreCase("success")) {
                        Intent intent = new Intent(VLoginActivity.this,VolunteerActivity.class);
                        startActivity(intent);
                        Toast.makeText(VLoginActivity.this, "login successful", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(VLoginActivity.this, "Unexpected Error", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(MainActivity.this, "Check your internet connection and proceed", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("vol_mobile", vmob);
                params.put("vol_pswd", vpass);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
