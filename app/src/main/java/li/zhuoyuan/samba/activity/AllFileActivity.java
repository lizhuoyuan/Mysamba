package li.zhuoyuan.samba.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import li.zhuoyuan.samba.R;
import li.zhuoyuan.samba.popwindow.SearchPopWindow;

public class AllFileActivity extends AppCompatActivity {

    private ImageView imgfoldadd, imgsort, imgright;
    private EditText searchEdittext;
    private TextView tvtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_file);
        initview();
        initevent();
    }

    private void initevent() {
        searchEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchPopWindow searchPopWindow = new SearchPopWindow(AllFileActivity.this);
                searchPopWindow.showPopupWindow(searchEdittext);
            }
        });
    }

    private void initview() {
        imgfoldadd = (ImageView) findViewById(R.id.imgfoldeadd);
        imgsort = (ImageView) findViewById(R.id.imgsort);
        searchEdittext = (EditText) findViewById(R.id.searchEdittext);
        searchEdittext.setKeyListener(null);
        tvtitle = (TextView) findViewById(R.id.title);
        tvtitle.setText("共享文档");
        imgright = (ImageView) findViewById(R.id.rightimg2);
        imgright.setVisibility(View.VISIBLE);
    }
}
