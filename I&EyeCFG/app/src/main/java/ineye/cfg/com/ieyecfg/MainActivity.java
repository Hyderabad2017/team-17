package ineye.cfg.com.ieyecfg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
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
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    String name,mail,phone;
    EditText m_name,m_mail,m_phone;
    private PrefManager prefManager;
    public static String url_reg="http://minimark.in/Android/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        m_name = (EditText) findViewById(R.id.name);
        m_name.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        m_mail = (EditText) findViewById(R.id.email);
        m_phone = (EditText) findViewById(R.id.phone);
    }

    public void goToDetails(View view) {

        String tag_string_req = "req_register";
        name = m_name.getText().toString();
        mail = m_mail.getText().toString();
        phone = m_phone.getText().toString();
        prefManager = new PrefManager(this);

        StringRequest strReq = new StringRequest(Request.Method.POST, url_reg, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jObj = new JSONObject(response);

                    String value = jObj.getString("uid");

                    if (value.equalsIgnoreCase("success")) {

                    }
                    else
                        Toast.makeText(MainActivity.this, "Unexpected Error", Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Check your internet connection and proceed", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("mail", mail);
                params.put("phone", phone);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    


}
