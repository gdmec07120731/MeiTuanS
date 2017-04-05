package com.ppjun.android.meituan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ppjun.android.meituan.MainAdapter.MainHolder.VIEW_HOLDER_IMAGE;
import static com.ppjun.android.meituan.MainAdapter.MainHolder.VIEW_HOLDER_LABLE;
import static com.ppjun.android.meituan.MainAdapter.MainHolder.VIEW_HOLDER_RV;
import static com.ppjun.android.meituan.MainAdapter.MainHolder.VIEW_HOLDER_VIEWPAGER;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_rv)
    RecyclerView mRv;

    Context mContext;
    MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        mRv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        mRv.setAdapter(mMainAdapter = new MainAdapter());
        mMainAdapter.setFragmentMnager(getSupportFragmentManager());
        mMainAdapter.addViewHolderType(
                VIEW_HOLDER_VIEWPAGER
                , VIEW_HOLDER_IMAGE
                , VIEW_HOLDER_LABLE
                , VIEW_HOLDER_RV);


    }
}
