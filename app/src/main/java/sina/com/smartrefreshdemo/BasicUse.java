package sina.com.smartrefreshdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class BasicUse extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        initView();

    }

    private void initView() {
        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setEnableAutoLoadmore(true);//开启自动加载功能（非必须）
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        ClassicsHeader refreshHeader = (ClassicsHeader) refreshLayout.getRefreshHeader();
        refreshHeader.setEnableLastTime(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                     //   mAdapter.refresh(initData());
                        refreshlayout.finishRefresh();
                        refreshlayout.resetNoMoreData();

                        Log.d("smart_refresh",">>>>>>>>>>>>>>>>>>onRefresh");
                    }
                }, 2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        mAdapter.loadmore(initData());
//                        if (mAdapter.getItemCount() > 60) {
//                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
//                            refreshlayout.finishLoadmoreWithNoMoreData();//将不会再次触发加载更多事件
//                        } else {
//                            refreshlayout.finishLoadmore();
//                        }
                        refreshlayout.finishLoadmore();
                        Log.d("smart_refresh",">>>>>>>>>>>>>>>>>>loadmore");
                    }
                }, 2000);
            }
        });


    }
}
