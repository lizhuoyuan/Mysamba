package li.zhuoyuan.samba.activity;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import li.zhuoyuan.samba.R;

public class AddServerActivity extends AppCompatActivity {
    private EditText ipedit, userEdit, passEdit;
    private TextView tvtitle, righttext;
    private LinearLayout leftbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addserver);
        initview();
        initevent();
    }

    private void initevent() {
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initview() {
        leftbtn = (LinearLayout) findViewById(R.id.leftbtn);
        userEdit = (EditText) findViewById(R.id.userEdit);
        passEdit = (EditText) findViewById(R.id.passEdit);
        Drawable drawable1 = getResources().getDrawable(R.drawable.iconuser, null);
        drawable1.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，50分别是长宽
        userEdit.setCompoundDrawables(null, null, drawable1, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.iconpswd, null);
        drawable2.setBounds(0, 0, 50, 50);
        passEdit.setCompoundDrawables(null, null, drawable2, null);
        righttext = (TextView) findViewById(R.id.righttext);
        tvtitle = (TextView) findViewById(R.id.title);
        tvtitle.setText("添加服务器");
        righttext.setVisibility(View.VISIBLE);
    }
}
