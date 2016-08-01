package li.zhuoyuan.samba.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import li.zhuoyuan.samba.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadFragment extends Fragment {

    private View view;
    private RadioButton rb1, rb2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_download, container, false);
        initview();
        return view;
    }

    private void initview() {
        rb1 = (RadioButton) view.findViewById(R.id.leftradio);
        rb2 = (RadioButton) view.findViewById(R.id.rightradio);
        rb2.setChecked(true);
    }


}
