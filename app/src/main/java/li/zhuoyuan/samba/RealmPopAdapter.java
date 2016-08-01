package li.zhuoyuan.samba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SunFly on 2015/11/29.
 */
public class RealmPopAdapter extends BaseAdapter {
    private ArrayList<HashMap<String,String>> dataList;
    private Context context;
    private EditText EditText;
    private PopupWindow popupWindow;
    private static String TAG ="RealmPopAdapter";
    public RealmPopAdapter(Context context, EditText EditText, ArrayList<HashMap<String, String>> dataList, PopupWindow popupWindow) {
        this.context = context;
        this.dataList = dataList;
        this.EditText = EditText;
        this.popupWindow = popupWindow;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        final HashMap<String,String> dataItem = this.dataList.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.pop_list_item, null);
            viewHolder.vpnName = (TextView) view.findViewById(R.id.realm_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText.setText(dataList.get(position).get("item"));
                if(popupWindow!=null && popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
        viewHolder.vpnName.setText((String) dataItem.get("item"));
        return view;
    }
    final static class ViewHolder {
        TextView vpnName;
    }
}
