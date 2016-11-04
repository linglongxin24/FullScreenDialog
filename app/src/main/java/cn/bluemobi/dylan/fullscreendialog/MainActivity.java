package cn.bluemobi.dylan.fullscreendialog;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
//                showFullScreenDialog();
            }
        });
    }

    private void showDialog() {
        Dialog dialog=new Dialog(this,R.style.Dialog_FullScreen);
        dialog.setContentView(R.layout.my_dialog);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
    }

    /**
     * 显示全屏宽度对话框
     */
    private void showFullScreenDialog() {
        FullScreenDialog bottomDialog = new FullScreenDialog();
        View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.my_dialog, null);
        bottomDialog.setGravity(Gravity.BOTTOM);
        bottomDialog.setContentView(dialogView);
        bottomDialog.show(getSupportFragmentManager(), "testdialog");
    }
}
