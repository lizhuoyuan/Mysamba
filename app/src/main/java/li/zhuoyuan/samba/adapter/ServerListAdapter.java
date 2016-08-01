package li.zhuoyuan.samba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import li.zhuoyuan.samba.R;

/**
 * Created by 卓原 on 2016/7/29.
 */

public class ServerListAdapter extends BaseAdapter {
    private ArrayList list;
    private LayoutInflater inflater;
    private boolean isHaveTime;

    public ServerListAdapter(Context context, ArrayList list, boolean isHaveTime) {
        this.list = list;
        this.isHaveTime = isHaveTime;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        ImageView leftimg, rightimg;
        TextView tv1, tv2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (null == view) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.view_server_list, null);
            holder.leftimg = (ImageView) view.findViewById(R.id.leftimg);
            holder.rightimg = (ImageView) view.findViewById(R.id.rightimg);
            holder.tv1 = (TextView) view.findViewById(R.id.tv1);
            holder.tv2 = (TextView) view.findViewById(R.id.tv2);
            if (isHaveTime == true) {
                holder.tv2.setVisibility(View.VISIBLE);
            } else {
                holder.tv2.setVisibility(View.GONE);
            }
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }
}
