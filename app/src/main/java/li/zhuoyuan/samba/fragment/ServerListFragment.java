package li.zhuoyuan.samba.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import li.zhuoyuan.samba.R;
import li.zhuoyuan.samba.activity.AllFileActivity;
import li.zhuoyuan.samba.adapter.ServerListAdapter;

public class ServerListFragment extends Fragment {
    private ImageView leftimg, rightimg;
    private TextView title;
    private View view;
    private ListView serverList;
    private LinearLayout rightlayout;
    private ArrayList list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_server_list, container, false);
        initview();
        initevent();

        return view;
    }

    private void initevent() {
        rightlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        serverList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(), AllFileActivity.class));
            }
        });
    }

    private void initview() {
        list = new ArrayList();
        serverList = (ListView) view.findViewById(R.id.serverlistview);
        leftimg = (ImageView) view.findViewById(R.id.leftimg);
        leftimg.setVisibility(View.GONE);
        rightimg = (ImageView) view.findViewById(R.id.rightimg1);
        rightimg.setVisibility(View.VISIBLE);
        title = (TextView) view.findViewById(R.id.title);
        title.setText("服务器列表");
        serverList = (ListView) view.findViewById(R.id.serverlistview);
        rightlayout = (LinearLayout) view.findViewById(R.id.rightbtn);
        ServerListAdapter adapter = new ServerListAdapter(getActivity(), list, false);
        serverList.setAdapter(adapter);
    }


}
