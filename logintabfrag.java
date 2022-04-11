package com.example.smarthomeautomation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class logintabfrag extends Fragment {

    EditText email;
    EditText pass;
    Button login;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.logintab, container, false);

        email = root.findViewById(R.id.lemail);
        pass = root.findViewById(R.id.lpassword);
        login = root.findViewById(R.id.login);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();

        return root;
    }
}
