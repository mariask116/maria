package com.maria.loginsignup.loginsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUserName1;
    private EditText etPassword1;
    private EditText etName;
    private EditText etConfirmPassword;
    private Button btnSignUp;
    private UserDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUserName1 = (EditText) findViewById(R.id.etUserName1);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);
        etName = (EditText) findViewById(R.id.etName);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        db = new UserDB(this);
    }

    public void createUser(View view) {
        String name = etName.getText().toString();
        String userName = etUserName1.getText().toString();
        String password = etPassword1.getText().toString();
        String ConfirmPassword = etConfirmPassword.getText().toString();
        User user = db.getUser(userName);

       /* User user=null;
        if(password.equals(etConfirmPassword))
        {
            user=new User(name,userName,password );
        }
        else
        {
            Toast.makeText(this, "Passwords are not equal!", Toast.LENGTH_LONG).show();

        }
*/
        if (user != null)
        {
            Toast.makeText(this, "User already exists", Toast.LENGTH_LONG.).show();
            return;
        }
        if (password.equals(user.getPassword()))
        {
            user = new User();
            user.setName(name);
            user.setUsername(userName);
            user.setPassword(password);
            db.addUser(user);
            Toast.makeText(this, "user succsfuy rgistered", Toast.LENGTH_LONG).show();
        }


    }

}
