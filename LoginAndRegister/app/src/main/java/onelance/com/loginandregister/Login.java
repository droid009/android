package onelance.com.loginandregister;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView signup;
    EditText Email, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = (TextView) findViewById(R.id.LSignup);
        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        Email = (EditText) findViewById(R.id.LEmail);
        Password = (EditText) findViewById(R.id.LPassword);
        Login = (Button) findViewById(R.id.Login);

    }

    public void OnLogin(View view) {
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,email,password);

        /*BackgroundTask backgroundTask = new BackgroundTask(Login.this);
        backgroundTask.execute("login",Email.getText().toString(),Password.getText().toString());*/
    }
}

