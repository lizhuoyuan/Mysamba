package li.zhuoyuan.samba.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;

import li.zhuoyuan.samba.R;
import li.zhuoyuan.samba.adapter.MyFragmentAdapter;
import li.zhuoyuan.samba.fragment.DownloadFragment;
import li.zhuoyuan.samba.fragment.LocalFragment;
import li.zhuoyuan.samba.fragment.ServerListFragment;
import li.zhuoyuan.samba.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView imgadd;
    private ArrayList<Fragment> fraglist;
    public RadioButton rb1, rb2, rb3, rb4;
    private Fragment serverListFragment, downloadFragment, localfragment, settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initevent();
    }

    private void initevent() {
        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddServerActivity.class));

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb1.setChecked(true);
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;
                    case 3:
                        rb4.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0, true);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1, true);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2, true);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3, true);
            }
        });
    }

    private void initView() {
        imgadd = (ImageView) findViewById(R.id.bottomImgadd);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        fraglist = new ArrayList<>();
        serverListFragment = new ServerListFragment();
        localfragment = new LocalFragment();
        downloadFragment = new DownloadFragment();
        settingFragment = new SettingFragment();
        fraglist.add(serverListFragment);
        fraglist.add(localfragment);
        fraglist.add(downloadFragment);
        fraglist.add(settingFragment);
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), fraglist);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        rb1.setChecked(true);
    }
}
