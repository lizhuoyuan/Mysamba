package li.zhuoyuan.samba.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import li.zhuoyuan.samba.R;

/**
 * Created by 卓原 on 2016/7/29.
 */

public class SearchPopWindow extends PopupWindow {
    private View view;
    private TextView tv;

    public SearchPopWindow(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.pop_search, null);
        // 使其聚集
        setFocusable(true);
        // 设置允许在外点击消失
        setOutsideTouchable(true);
        setContentView(view);
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置popupWindow弹出窗体的背景 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        setBackgroundDrawable(new ColorDrawable(0000000000));
        tv = (TextView) view.findViewById(R.id.tvcancel);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    public void showPopupWindow(View view) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            showAsDropDown(view);
          //  showAtLocation(view, Gravity.BOTTOM, 0, 0);
        }
    }
}
