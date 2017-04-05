package com.ppjun.android.meituan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Package :com.ppjun.android.meituan
 * Description :
 * Author :Rc3
 * Created at :2017/04/05 18:56.
 */

public class ViewpPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_type_view, container, false);

    }
}
