package ineye.cfg.com.ieyecfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
 * Created by swapna on 15-07-2017.
 */

public class VRegActivity extends AppCompatActivity {
    private EditText e_name,e_email,e_mobile,e_qual,e_loc,e_lang,e_pass;
    private String name,email,mobile,qual,loc,lang,gender,pass;
    private PrefManager prefManager;
    private RadioGroup r_gender;
    private RadioButton radiogender;
    public static String url_reg="http://192.168.43.96/cfg_connection/vol_register.php";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vreg);

        e_name=(EditText)findViewById(R.id.et_name);
        e_email=(EditText)findViewById(R.id.et_email);
        e_mobile=(EditText)findViewById(R.id.et_mobile);
        e_qual=(EditText)findViewById(R.id.et_qualification);
        e_loc=(EditText)findViewById(R.id.et_location);
        e_lang=(EditText)findViewById(R.id.et_language);
        e_pass=(EditText)findViewById(R.id.et_password);

        r_gender=(RadioGroup)findViewById(R.id.rb_gender);

        //int selectedId=r_gender.getCheckedRadioButtonId();
       // radiogender=(RadioButton)findViewById(selectedId);


    }

    public void goToRegMain(View view) {

        String tag_string_req = "req_register";
        name = e_name.getText().toString();
        email = e_email.getText().toString();
        mobile = e_mobile.getText().toString();
        qual = e_qual.getText().toString();
        loc = e_loc.getText().toString();
        lang = e_lang.getText().toString();
        pass= e_pass.getText().toString();
        gender="female";

        prefManager = new PrefManager(this);

        StringRequest strReq = new StringRequest(Request.Method.POST, url_reg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VRegActivity.this, response, Toast.LENGTH_LONG).show();

                try {
                    JSONObject jObj = new JSONObject(response);

                    String value = jObj.getString("uid");

                    if (value.equalsIgnoreCase("success")) {
                        Intent intent = new Intent(VRegActivity.this,VolunteerActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(VRegActivity.this, "Unexpected Error", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(VRegActivity.this, "Check your internet connection and proceed", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("vol_name", name);
                params.put("vol_email", email);
                params.put("vol_gender", gender);
                params.put("mobile", mobile);
                params.put("city", loc);
                params.put("language", lang);
                params.put("qualification", qual);
                params.put("vol_pswd", pass);


                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }



}
