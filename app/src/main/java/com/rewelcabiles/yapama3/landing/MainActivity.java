package com.rewelcabiles.yapama3.landing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.rewelcabiles.yapama3.R;
import com.rewelcabiles.yapama3.passwordList.PasswordListActivity;

public class MainActivity extends AppCompatActivity {

    private FragmentContainerView fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = (FragmentContainerView) findViewById(R.id.fragment_container);

        SharedPreferences userDetails = getSharedPreferences("userPreferences", MODE_PRIVATE);
        if (userDetails.getBoolean("didFirstSetup", true) == false) {

        }

    }

    public void login() {
        Intent intent = new Intent(this, PasswordListActivity.class);
        startActivity(intent);
    }

    public void openFragment(String next_fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        if (next_fragment == "encrypt") {
            Setup2Fragment fragment = Setup2Fragment.newInstance();
            transaction.replace(R.id.fragment_container, fragment, "next_fragment");
        } else if (next_fragment =="storage") {
            Setup1Fragment fragment = Setup1Fragment.newInstance();
            transaction.replace(R.id.fragment_container, fragment, "next_fragment");
        } else if (next_fragment == "login"){
            LoginFragment fragment = LoginFragment.newInstance();
            transaction.replace(R.id.fragment_container, fragment, "next_fragment");
        }
        transaction.commit();
    }

    public void setStorage(String storage) {
        SharedPreferences userDetails = getSharedPreferences("userPreferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("storageType", storage);
        edit.apply();
        openFragment("encrypt");
    }

    public void setEncrypt(String encrypt) {
        SharedPreferences userDetails = getSharedPreferences("userPreferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.putString("encryptType", encrypt);
        edit.apply();
        openFragment("login");
    }
}