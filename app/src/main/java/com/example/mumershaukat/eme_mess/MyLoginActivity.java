package com.example.mumershaukat.eme_mess;


        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import static android.R.attr.start;

public class MyLoginActivity extends AppCompatActivity {

    Button LoginButton;
    EditText UserNameEt, PasswordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
getSupportActionBar().hide();
       /*LoginButton=(Button)findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                //Intent i=new Intent(MyLoginActivity.this,AfterLoginActivity.class);
                 //startActivity(i);

            }
       });*/

        UserNameEt=(EditText)findViewById(R.id.LoginId);
        PasswordEt=(EditText)findViewById(R.id.Password);


    }
    Data NAME =Data.getInstance();
    public  void OnLogin(View view){

        String username=UserNameEt.getText().toString();
        String password=PasswordEt.getText().toString();
        NAME.var(username);
        String type="login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type,username,password);
    }


}

