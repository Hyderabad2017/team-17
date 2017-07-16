package ineye.cfg.com.ieyecfg;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by swapna on 16-07-2017.
 */

public class StudentActivity extends AppCompatActivity {
    EditText e_sname,e_sexam,e_sexamdate,e_sloc,e_smobile,e_slang,e_semail;
    String sname,sexam,sexamdate,sloc,sgender,smobile,slang,semail;
    private RadioGroup r_gender;
    private PrefManager prefManager;
    private RadioButton radiogender;
    private Spinner s_sexam;
    public static String url_reg="http://192.168.43.96/cfg_connection/stu_request.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        e_sname =(EditText) findViewById(R.id.et_sname);

        e_sexamdate =(EditText) findViewById(R.id.et_sexamdate);
        e_smobile =(EditText) findViewById(R.id.et_smobile);
        e_slang =(EditText) findViewById(R.id.et_slang);
        e_semail =(EditText) findViewById(R.id.et_semail);



        final String[] paths2 = {"Select Exam","10th Exams","CA Exam"};

        s_sexam = (Spinner) findViewById(R.id.s_sexam);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(StudentActivity.this,
                android.R.layout.simple_spinner_item, paths2);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_sexam.setAdapter(adapter);
        s_sexam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch (pos) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        break;
                    case 1:
                        sexam=paths2[1];
                        break;
                    case 2:
                        sexam=paths2[2];
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
                        sexam="not known";
            }
        });


    }

    public void createRequest(View view) {

        String tag_string_req = "req_register";
        sname = e_sname.getText().toString();

        smobile = e_smobile.getText().toString();
        sexamdate = e_sexamdate.getText().toString();
        sloc = "not yet determined";
        slang = e_slang.getText().toString();
        semail=e_semail.getText().toString();
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
                        try {
                            ArrayList<String> mobilelist = new ArrayList<String>();
                            JSONArray arr  = jObj.getJSONArray("data");



                            if (arr != null) {
                                int len = arr.length();
                                for (int i=0;i<len;i++){

                                   sendSMSToVol(arr.getString(i));

                                }
                            }
                        }catch (Exception e){
                        e.printStackTrace();
                        }
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

    public void sendSMSToVol(String no){
        SmsManager smsManager = SmsManager.getDefault();


        Intent intent=new Intent(getApplicationContext(),StudentActivity.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        smsManager.sendTextMessage(no, null, "Would you like to be a scribe for Mr.A?", pi, null);
        Toast.makeText(StudentActivity.this, "Message sent to"+no, Toast.LENGTH_SHORT).show();
    }


}
