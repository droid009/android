package onelance.com.loginandregister;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText Name, Email, Password, ConPass,Phone;
    Button Register;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText)findViewById(R.id.RName);
        Email = (EditText)findViewById(R.id.REmail);
        Password = (EditText)findViewById(R.id.RPassword);
        ConPass = (EditText)findViewById(R.id.RConPassword);
        Phone = (EditText)findViewById(R.id.RPhone);
        Register = (Button)findViewById(R.id.RSignUp);
        Register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                if(Name.getText().toString().equals("")||Email.getText().toString().equals("")||Password.getText().equals("")||ConPass.getText().equals("")||Phone.getText().equals(""))
                {
                    alert = new AlertDialog.Builder(Register.this);
                    alert.setTitle("Something Went Wrong...");
                    alert.setMessage("Please fill all the fields..");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog= alert.create();
                    alertDialog.show();
                }
                else if (!(Password.getText().toString().equals(ConPass.getText().toString())))
                {
                    alert = new AlertDialog.Builder(Register.this);
                    alert.setTitle("Something Went Wrong...");
                    alert.setMessage("Pass are not match..");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Password.setText("");
                            ConPass.setText("");
                        }
                    });
                    AlertDialog alertDialog= alert.create();
                    alertDialog.show();
                }
                else
                {
                 BackgroundTask backgroundTask = new BackgroundTask(Register.this);
                    backgroundTask.execute("register",Name.getText().toString(),Email.getText().toString(),Password.getText().toString(),Phone.toString());
                }
            }
        });
    }
}
