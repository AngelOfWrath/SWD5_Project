package com.example.swd5_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        public void login(View view) throws JSONException
        {
            JSONObject json = new JSONObject();
            EditText login = findViewById(R.id.editText);
            EditText pass = findViewById(R.id.editText);
            json.put("login",login.getText().toString());
            json.put("pass",pass.getText().toString());

            String URL = "https://jsonplaceholder.typicode.com/todos/1";

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    URL,
                    json,
                    new Response.Listener<JSONObject>(){
                        public void onResponse(JSONObject response){
                            Log.e("Response",response.toString());
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Response",error.toString());
                        }
                    }
            )
            {
                @Override
                public Map getHeaders(){
                    HashMap header = new HashMap();
// header.put("Test-Content","test");
                    return header;
                }
            };

            requestQueue.add(objectRequest);

    }
}
