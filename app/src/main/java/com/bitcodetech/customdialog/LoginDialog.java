package com.bitcodetech.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends Dialog {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private Context context;


    public interface OnLoginListener {
        void onSuccess(LoginDialog loginDialog);
        void onFailure(LoginDialog loginDialog);
    }

    private OnLoginListener onLoginListener = null;

    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(Context context) {
        super(context);
        this.context = context;

        setContentView(R.layout.login_dialog);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(edtUsername.getText().toString().equals("bitcode")) {
                /*mt("Login Successful!");
                dismiss();*/
                //code to delegate the event to the listener
                if(onLoginListener != null) {
                    onLoginListener.onSuccess(LoginDialog.this);
                }
            }
            else {
                /*mt("Login failed!");*/
                //code to delegate the event to the listener
                if(onLoginListener != null) {
                    onLoginListener.onFailure(LoginDialog.this);
                }
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
