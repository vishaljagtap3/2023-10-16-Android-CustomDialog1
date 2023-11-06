package com.bitcodetech.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class PlayerDialog extends Dialog {

    private TextView txtPlayer1, txtPlayer2, txtPlayer3, txtPlayer4;

    public interface OnPlayerSelectedListener {
        void onPlayerSelected(String playerName, PlayerDialog playerDialog);
    }

    private OnPlayerSelectedListener onPlayerSelectedListener = null;

    public void setOnPlayerSelectedListener(
            OnPlayerSelectedListener onPlayerSelectedListener
    ) {
        this.onPlayerSelectedListener = onPlayerSelectedListener;
    }

    public PlayerDialog(Context context) {
        super(context);
        setContentView(R.layout.player_dialog);
        initViews();

        TxtPlayerClickListener txtPlayerClickListener =
                new TxtPlayerClickListener();
        txtPlayer1.setOnClickListener(txtPlayerClickListener);
        txtPlayer2.setOnClickListener(txtPlayerClickListener);
        txtPlayer3.setOnClickListener(txtPlayerClickListener);
        txtPlayer4.setOnClickListener(txtPlayerClickListener);

    }

    private class TxtPlayerClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if(onPlayerSelectedListener == null) {
                return;
            }

            if(view == txtPlayer1) {
                onPlayerSelectedListener.onPlayerSelected(
                        txtPlayer1.getText().toString(),
                        PlayerDialog.this
                );
            }
            if(view == txtPlayer2) {
                onPlayerSelectedListener.onPlayerSelected(
                        txtPlayer2.getText().toString(),
                        PlayerDialog.this
                );
            }
            if(view == txtPlayer3) {
                onPlayerSelectedListener.onPlayerSelected(
                        txtPlayer3.getText().toString(),
                        PlayerDialog.this
                );
            }
            if(view == txtPlayer4) {
                onPlayerSelectedListener.onPlayerSelected(
                        txtPlayer4.getText().toString(),
                        PlayerDialog.this
                );
            }
        }
    }

    private void initViews() {
        txtPlayer1 = findViewById(R.id.txtPlayer1);
        txtPlayer2 = findViewById(R.id.txtPlayer2);
        txtPlayer3 = findViewById(R.id.txtPlayer3);
        txtPlayer4 = findViewById(R.id.txtPlayer4);
    }
}
