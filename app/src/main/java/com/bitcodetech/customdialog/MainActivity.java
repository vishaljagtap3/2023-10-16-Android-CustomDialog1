package com.bitcodetech.customdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSelectPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSelectPlayer = findViewById(R.id.btnSelectPlayer);

        btnSelectPlayer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PlayerDialog playerDialog = new PlayerDialog(MainActivity.this);
                        playerDialog.setOnPlayerSelectedListener(
                                new MyOnPlayerSelectedListener()
                        );
                        playerDialog.show();
                    }
                }
        );

        btnSignIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                        loginDialog.setOnLoginListener(new MyOnLoginListener());
                        loginDialog.show();
                    }
                }
        );
    }

    private class MyOnPlayerSelectedListener implements PlayerDialog.OnPlayerSelectedListener {
        @Override
        public void onPlayerSelected(String playerName, PlayerDialog playerDialog) {
            playerDialog.dismiss();
            btnSelectPlayer.setText(playerName);
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private class MyOnLoginListener implements LoginDialog.OnLoginListener {
        @Override
        public void onSuccess(LoginDialog loginDialog) {
            mt("My success action");
            loginDialog.dismiss();
        }

        @Override
        public void onFailure(LoginDialog loginDialog) {
            mt("My failure action");
        }
    }
}
