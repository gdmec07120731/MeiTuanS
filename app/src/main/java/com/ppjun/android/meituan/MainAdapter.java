package com.ppjun.android.meituan;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Package :com.ppjun.android.meituan
 * Description :
 * Author :Rc3
 * Created at :2017/4/1 17:39.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    List<Integer> viewholderTypes = new ArrayList<>();
    Context mContext;

    @Override
    public int getItemViewType(int position) {
        return viewholderTypes.get(position);
    }

    FragmentManager mFragmentManager;
    public void setFragmentMnager(FragmentManager f){
        this.mFragmentManager=f;
    }

    public void addViewHolderType(int... type) {
        for (int i = 0; i < type.length; i++) {
            viewholderTypes.add(type[i]);
        }
        notifyDataSetChanged();
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return MainHolder.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        if (holder instanceof MainHolder.ViewHolderViewPager) {
            List<Fragment> l = new ArrayList<Fragment>();
            Fragment f = new ViewpPagerFragment();
            Fragment f1 = new ViewpPagerFragment();
            l.add(f);
            l.add(f1);
            MyPagerAdapter adapter=new MyPagerAdapter(mFragmentManager,l);

       ((MainHolder.ViewHolderViewPager) holder).mViewPager.setAdapter(adapter);

        } else if (holder instanceof MainHolder.ViewHolderImage) {

        } else if (holder instanceof MainHolder.ViewHolderLable) {

        } else if (holder instanceof MainHolder.ViewHolderRv) {

          ((MainHolder.ViewHolderRv) holder).mRv.setAdapter(new RvAdapter());
        }
    }

    @Override
    public int getItemCount() {
        return viewholderTypes.size();
    }

    public static abstract class MainHolder extends RecyclerView.ViewHolder {

        public static final int VIEW_HOLDER_VIEWPAGER = 0;
        public static final int VIEW_HOLDER_IMAGE = VIEW_HOLDER_VIEWPAGER + 1;
        public static final int VIEW_HOLDER_LABLE = VIEW_HOLDER_IMAGE + 1;
        public static final int VIEW_HOLDER_RV = VIEW_HOLDER_LABLE + 1;

        public MainHolder(View itemView) {
            super(itemView);

        }

        public static MainHolder create(ViewGroup viewgroup, int viewtype) {
            switch (viewtype) {
                case VIEW_HOLDER_VIEWPAGER:
                    return ViewHolderViewPager.create(viewgroup);
                case VIEW_HOLDER_IMAGE:
                    return ViewHolderImage.create(viewgroup);
                case VIEW_HOLDER_LABLE:
                    return ViewHolderLable.create(viewgroup);
                case VIEW_HOLDER_RV:
                    return ViewHolderRv.create(viewgroup);
                default:
                    return null;
            }
        }

        public static class ViewHolderViewPager extends MainHolder {

           ViewPager mViewPager;

            public ViewHolderViewPager(View itemView) {
                super(itemView);
                mViewPager= (ViewPager) itemView.findViewById(R.id.asdasd_viewpager);
                Log.i(TAG, "ViewHolderViewPager: init");

            }

            public static ViewHolderViewPager create(ViewGroup parent) {
                return new ViewHolderViewPager(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.main_type_viewpager, null));
            }
        }


        public static class ViewHolderImage extends MainHolder {


            public ViewHolderImage(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public static ViewHolderImage create(ViewGroup parent) {
                return new ViewHolderImage(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_img_view, parent, false));
            }
        }

        public static class ViewHolderLable extends MainHolder {


            public ViewHolderLable(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            public static ViewHolderLable create(ViewGroup parent) {
                return new ViewHolderLable(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_lable_view, parent, false));
            }
        }

        public static class ViewHolderRv extends MainHolder {
            @BindView(R.id.rv)
            RecyclerView mRv;

            public ViewHolderRv(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mRv.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false));
            }

            public static ViewHolderRv  create(ViewGroup parent) {
                return new ViewHolderRv (LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv_view, parent, false));
            }
        }
    }
}
