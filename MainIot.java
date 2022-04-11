package com.example.smarthomeautomation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainIot extends AppCompatActivity {

    private Button newdev;
    private Button logout;

    TextView tem;
    TextView hum;

    ImageView led1;
    ImageView led2;

    TextView l1stat;
    TextView l2stat;

    TextView pir;

    String valuepir;
    String valuedhtt;
    String valuedhth;
    String valuel1;
    String valuel2;

    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_iot);

        newdev = findViewById(R.id.newdevice);
        logout = findViewById(R.id.logout);

        tem = findViewById(R.id.tempval);
        hum = findViewById(R.id.humval);

        led1 = findViewById(R.id.light1);
        led2 = findViewById(R.id.light2);

        l1stat = findViewById(R.id.lstat1);
        l2stat = findViewById(R.id.lstat2);

        pir = findViewById(R.id.mdstat);

        newdev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainIot.this,"Feature will be available soon!",Toast.LENGTH_SHORT).show();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainIot.this);
                builder.setMessage("Are you sure you want to Logout?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(MainIot.this,"Logged out successfully!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainIot.this, MainActivity.class));
                    }
                }).setNegativeButton("NO",null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //pir data

                valuepir = snapshot.child("room1/pir").getValue().toString();
                if(valuepir.equals("0"))
                    pir.setText("No Motion Detected");
                else
                    pir.setText("Motion Detected! There's someone in your room!");

                //temperature and humidity data

                valuedhtt = snapshot.child("room1/dht/temp").getValue().toString();
                tem.setText(valuedhtt);

                valuedhth = snapshot.child("room1/dht/humid").getValue().toString();
                hum.setText(valuedhth);

                //led status

                valuel1 = snapshot.child("room1/led1").getValue().toString();
                if(valuel1.equals("0")) {
                    l1stat.setText("OFF");
                }
                else {
                    l1stat.setText("ON");
                }

                valuel2 = snapshot.child("room1/led2").getValue().toString();
                if(valuel2.equals("0")) {
                    l2stat.setText("OFF");
                }
                else {
                    l2stat.setText("ON");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        led1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference led1ref = FirebaseDatabase.getInstance().getReference("room1/led1");
                led1ref.setValue(1);
                Toast.makeText(MainIot.this,"Turning On Led 1", Toast.LENGTH_SHORT).show();
            }
        });

        led1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DatabaseReference led1ref = FirebaseDatabase.getInstance().getReference("room1/led1");
                led1ref.setValue(0);
                Toast.makeText(MainIot.this,"Turning Off Led 1", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        led2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference led2ref = FirebaseDatabase.getInstance().getReference("room1/led2");
                led2ref.setValue(1);
                Toast.makeText(MainIot.this,"Turning On Led 2", Toast.LENGTH_SHORT).show();
            }
        });

        led2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DatabaseReference led2ref = FirebaseDatabase.getInstance().getReference("room1/led2");
                led2ref.setValue(0);
                Toast.makeText(MainIot.this,"Turning Off Led 2", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}