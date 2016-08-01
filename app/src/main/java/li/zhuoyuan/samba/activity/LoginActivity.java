package li.zhuoyuan.samba.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import li.zhuoyuan.samba.R;

public class LoginActivity extends AppCompatActivity {

    private EditText ipedit, userEdit, passEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
        initevent();
    }

    private void initevent() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        ipedit.setKeyListener(null);
        ipedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "该好好好好", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initview() {
        ipedit = (EditText) findViewById(R.id.ipedit);
        userEdit = (EditText) findViewById(R.id.userEdit);
        passEdit = (EditText) findViewById(R.id.passEdit);
        Drawable drawable1 = getResources().getDrawable(R.drawable.iconuser, null);
        drawable1.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        userEdit.setCompoundDrawables(null, null, drawable1, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.iconpswd, null);
        drawable2.setBounds(0, 0, 50, 50);
        passEdit.setCompoundDrawables(null, null, drawable2, null);
        Drawable drawable3 = getResources().getDrawable(R.drawable.arrow01, null);
        drawable3.setBounds(0, 0, 50, 50);
        ipedit.setCompoundDrawables(null, null, drawable3, null);
        login = (Button) findViewById(R.id.login);
    }
}
