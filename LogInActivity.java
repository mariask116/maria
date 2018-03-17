package com.maria.loginsignup.loginsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {


    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogIn;
    private Button btnSignUp;
    private UserDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        etUserName =(EditText)findViewById(R.id.etUserName);
        etPassword =(EditText)findViewById(R.id.etPassword);
        btnLogIn =(Button)findViewById(R.id.btnLogIn);
        btnSignUp =(Button)findViewById(R.id.btnSignUp);
        db=new UserDB(this);

    }


    public void checkUsernamePassword(View view) {
        String username= etUserName.getText().toString();
        String password= etPassword.getText().toString();

       User user=db.getUser(username);
       if(user==null)
       {Toast.makeText(this,"User dosnt exist", Toast.LENGTH_SHORT).show();
       return;

       }
       if(password.equals(user.getPassword()))
       {
           Intent i=new Intent(this,    NewsfeedActivity.class);
           startActivity(i);
       }




        /* if(username.equals("admin")&& password.equals("admin"))
         {
             Intent i=new Intent(this, NewsfeedActivity.class);
             startActivity(i);
         }
         else
         {
             Toast.makeText(this, "Username or password is incorect ", Toast.LENGTH_LONG).show();
         }

*/
    }

}
