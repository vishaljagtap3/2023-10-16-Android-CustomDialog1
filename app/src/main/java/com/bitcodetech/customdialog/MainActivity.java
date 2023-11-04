package com.bitcodetech.customdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                        //loginDialog.setOnLoginListener(new MyOnLoginListener());
                        loginDialog.show();
                    }
                }
        );
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private class MyOnLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess() {
            mt("My success action");
        }

        @Override
        public void onFailure() {
            mt("My failure action");
        }
    }
}
