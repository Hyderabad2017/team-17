package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
 * Created by swapn on 16-07-2017.
 */

public class StudentActivity extends AppCompatActivity {
    EditText e_sname,e_sexam,e_sexamdate,e_sloc,e_smobile,e_slang,e_semail;
    String sname,sexam,sexamdate,sloc,sgender,smobile,slang,semail;
    private RadioGroup r_gender;
    private PrefManager prefManager;
    private RadioButton radiogender;
    public static String url_reg="http://192.168.43.96/cfg_connection/stu_request.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        e_sname =(EditText) findViewById(R.id.et_sname);
        e_sexam =(EditText) findViewById(R.id.et_sexam);
        e_sexamdate =(EditText) findViewById(R.id.et_sexamdate);
        e_smobile =(EditText) findViewById(R.id.et_smobile);
        e_slang =(EditText) findViewById(R.id.et_slang);
        e_semail =(EditText) findViewById(R.id.et_semail);

    }

    public void createRequest(View view) {

        String tag_string_req = "req_register";
        sname = e_sname.getText().toString();
        sexam = e_sexam.getText().toString();
        smobile = e_smobile.getText().toString();
        sexamdate = e_sexamdate.getText().toString();
        sloc = e_sloc.getText().toString();
        slang = e_slang.getText().toString();
        e_sname =(EditText) findViewById(R.id.et_sname);
        sgender="female";

        prefManager = new PrefManager(this);

        StringRequest strReq = new StringRequest(Request.Method.POST, url_reg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(StudentActivity.this, response, Toast.LENGTH_LONG).show();

                try {
                    JSONObject jObj = new JSONObject(response);

                    String value = jObj.getString("uid");

                    if (value.equalsIgnoreCase("success")) {
                        Toast.makeText(StudentActivity.this, "Request Created", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(StudentActivity.this, "Unexpected Error", Toast.LENGTH_SHORT).show();

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
                params.put("stu_name", sname);
                params.put("stu_exam", sexam);
                params.put("exam_date", sexamdate);
                params.put("location", sloc);
                params.put("stu_gender", sgender);
                params.put("stu_mobile", smobile);
                params.put("stu_language", slang);
                params.put("stu_email", semail);


                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    public void sendSMSToVol(){
        
    }


}
