package com.example.smarthomeautomation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class signuptabfrag extends Fragment {

    EditText email;
    EditText pass;
    Button reg;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signuptab, container, false);

        email = root.findViewById(R.id.semail);
        pass = root.findViewById(R.id.spassword);
        reg = root.findViewById(R.id.register);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        reg.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        reg.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();
        reg.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();



        return root;
    }
}
