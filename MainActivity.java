package com.example.smarthomeautomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //private Button login;
    //private Button register;

    //TabLayout tabLayout;
    //ViewPager viewPager;
    float v=0;

    private EditText email;
    private EditText password;
    private Button login;
    private TextView logint;
    private TextView newus;

    private FirebaseAuth auth;

    private Button register;

    ImageView applogo;
    TextView title1,title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register = findViewById(R.id.register);
        //login = findViewById(R.id.login);

        applogo = findViewById(R.id.logo);
        title1 = findViewById(R.id.welcome);
        title2 = findViewById(R.id.title);

        email = findViewById(R.id.lemail);
        password = findViewById(R.id.lpassword);
        login = findViewById(R.id.login);
        logint = findViewById(R.id.title1);

        register = findViewById(R.id.register);
        newus = findViewById(R.id.nuser);

        auth = FirebaseAuth.getInstance();

        //tabLayout = findViewById(R.id.tabLayout);
        //viewPager = findViewById(R.id.viewPager);

        applogo.animate().translationY(-540).translationX(-420).setDuration(1000).setStartDelay(4000).start();
        title1.animate().translationY(-1600).setDuration(1000).setStartDelay(4000).start();
        title2.animate().translationY(-830).translationX(90).setDuration(1000).setStartDelay(4000).start();

        logint.setAlpha(v);
        email.setAlpha(v);
        password.setAlpha(v);
        login.setAlpha(v);
        newus.setAlpha(v);
        register.setAlpha(v);


        logint.setTranslationX(800);
        email.setTranslationX(800);
        password.setTranslationX(800);
        login.setTranslationX(800);
        newus.setTranslationX(800);
        register.setTranslationX(800);


        logint.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();
        email.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();
        password.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();
        login.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();
        newus.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();
        register.animate().alpha(1).translationX(0).setDuration(1000).setStartDelay(5000).start();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_pass = password.getText().toString();

                loginUser(txt_email,txt_pass);
            }
        });

        //tabLayout.addTab(tabLayout.newTab().setText("Login"));
        //tabLayout.addTab(tabLayout.newTab().setText("Signup"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //final LoginAdap adap = new LoginAdap(getSupportFragmentManager(), this, tabLayout.getTabCount());
        //viewPager.setAdapter(adap);

        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //tabLayout.setAlpha(v);

        //tabLayout.animate().translationY(-1550).alpha(1).setDuration(1000).setStartDelay(5000).start();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
                finish();
            }
        });

        //login.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
              //  startActivity(new Intent(MainActivity.this, LoginActivity.class));
                //finish();
            //}
        //});
    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainIot.class));
                finish();
            }
        });
    }

}