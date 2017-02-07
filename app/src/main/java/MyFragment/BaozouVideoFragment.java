package MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import Adapter.BaseAdapter;
import Adapter.RecyclerViewBaseAdapter;
import DataBean.BaozouVideoGsonBean;
import DataBean.BaseBean;
import MyUtils.LogUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import skkk.cleanwaterinformation.R;
import skkk.cleanwaterinformation.WebVideoActivity;

/**
 * Created by admin on 2017/2/6.
 */
/*
* 
* 描    述：暴走日报的fragment
* 作    者：ksheng
* 时    间：2017/2/6$ 22:34$.
*/

public class BaozouVideoFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate{
    @Bind(R.id.rv_huxiu)
    RecyclerView rvData;
    @Bind(R.id.rv_refresh)
    BGARefreshLayout mRefreshLayout;



    private List<BaseBean> mDataList=new ArrayList<BaseBean>();
    private BaseAdapter adapter;
    private Retrofit retrofit;

    private static final String BASE_URL="http://dailyapi.ibaozou.com/";
    private WebService service;
    private String tableName;
    private int timeStamp;//时间戳


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View huxiuView=inflater.inflate(R.layout.fragment_huxiu,container,false);
        ButterKnife.bind(this,huxiuView);
        initRefreshLayout();
        initUI();
        initData();
        initEvent();

        return huxiuView;
    }

    private void initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGANormalRefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getContext(),true);
//        refreshViewHolder.setOriginalImage(R.drawable.loading);
//        refreshViewHolder.setUltimateColor(R.color.colorPrimaryDark);
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);


        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
        // 设置正在加载更多时不显示加载更多控件
        // mRefreshLayout.setIsShowLoadingMoreView(false);
        // 设置正在加载更多时的文本
        refreshViewHolder.setLoadingMoreText("正在加载...");
//        // 设置整个加载更多控件的背景颜色资源 id
//        refreshViewHolder.setLoadMoreBackgroundColorRes();
//        // 设置整个加载更多控件的背景 drawable 资源 id
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.drawable.ic_menu_camera);
//        // 设置下拉刷新控件的背景颜色资源 id
//        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
        // 设置下拉刷新控件的背景 drawable 资源 id
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(R.drawable.ic_menu_gallery);
//        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        mRefreshLayout.setCustomHeaderView(mBanner, false);
        // 可选配置  -------------END
    }


    /*
    ***************************************************
    * @方法 初始化UI
    * @参数
    * @返回值
    */
    private void initUI() {
        /* @描述 设置Adapter */
        adapter = new BaseAdapter(getContext(),mDataList);
        /* @描述 布局 */
//        rvData.setLinearLayout();
        LinearLayoutManager llManager=new LinearLayoutManager(getContext());
        rvData.setLayoutManager(llManager);
        /* @描述 设置间距 */
        SpacesItemDecoration mDecoration = new SpacesItemDecoration(3);
        /* @描述 添加间距 */
        rvData.addItemDecoration(mDecoration);
        /* @描述 设置基本动画 */
        rvData.setItemAnimator(new DefaultItemAnimator());
        /* @描述 rvNoteList */
        rvData.setAdapter(adapter);

    }

    /*
    ***************************************************
    * @方法 获取数据
    * @参数
    * @返回值
    */
    private void initData() {
        //新的配置
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(WebService.class);
        mRefreshLayout.beginRefreshing();
    }


    /*
    ***************************************************
    * @方法 设置监听事件
    * @参数
    * @返回值
    */
    private void initEvent() {

        adapter.setOnItemClickLitener(new RecyclerViewBaseAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent itemIntent=new Intent();
                itemIntent.putExtra("url",mDataList.get(position).getContentURL());
                itemIntent.putExtra("title",mDataList.get(position).getTitle()
                        .replace("\uE40B"," ").replace("\uE40A"," "));
                itemIntent.setClass(getContext(), WebVideoActivity.class);
                startActivity(itemIntent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }



    public void insertHXData(WebService service) {
        service.getBaozouVideoGsonBean()
                .subscribeOn(Schedulers.io())
                .map(new Func1<BaozouVideoGsonBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(BaozouVideoGsonBean baozouVideoGsonBean) {
                        //获取时间戳
                        timeStamp=baozouVideoGsonBean.getTimestamp();

                        List<BaozouVideoGsonBean.DataBean> results = baozouVideoGsonBean.getData();
                        List<BaseBean> responses=new ArrayList<BaseBean>();
//                        LogUtils.Log(""+results.size());

                        for (BaozouVideoGsonBean.DataBean resultsBean:results){

//                            LogUtils.Log(resultsBean.getTitle());

                            BaseBean baseBean =new BaseBean();
                            baseBean.setTitle(resultsBean.getTitle());
                            baseBean.setImgSrc(resultsBean.getImage());
                            baseBean.setContentURL(resultsBean.getFile_url());
                            responses.add(baseBean);

                        }
                        return responses;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<BaseBean>>() {
                    @Override
                    public void onCompleted() {
//                        LogUtils.Log("completed");
                        mRefreshLayout.endRefreshing();
                        mRefreshLayout.endLoadingMore();
//                        if (rvData.isRefresh()) {
//                            rvData.setPullLoadMoreCompleted();
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BaseBean> huXiuList) {
                        LogUtils.Log("这里这里这里是一开始~~~"+huXiuList.size()+"");
                        adapter.append(huXiuList);
                    }
                });
    }

    public void insertHXData(WebService service,int thisTimeStamp) {
        service.getNextBaozouVideoGsonBean(thisTimeStamp)
                .subscribeOn(Schedulers.io())
                .map(new Func1<BaozouVideoGsonBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(BaozouVideoGsonBean baozouVideoGsonBean) {
                        //获取时间戳
                        timeStamp=baozouVideoGsonBean.getTimestamp();

                        List<BaozouVideoGsonBean.DataBean> results = baozouVideoGsonBean.getData();
                        List<BaseBean> responses=new ArrayList<BaseBean>();

                        for (BaozouVideoGsonBean.DataBean resultsBean:results){
//                            LogUtils.Log(resultsBean.getTitle());
                            BaseBean baseBean =new BaseBean();
                            baseBean.setTitle(resultsBean.getTitle());
                            baseBean.setImgSrc(resultsBean.getImage());
                            baseBean.setContentURL(resultsBean.getFile_url());
                            responses.add(baseBean);
                        }
                        return responses;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<BaseBean>>() {
                    @Override
                    public void onCompleted() {
//                        LogUtils.Log("completed");
                        mRefreshLayout.endRefreshing();
                        mRefreshLayout.endLoadingMore();
//                        if (rvData.isRefresh()) {
//                            rvData.setPullLoadMoreCompleted();
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<BaseBean> huXiuList) {
                        LogUtils.Log("这里这里这里~~~"+huXiuList.size()+"");
                        adapter.append(huXiuList);
                    }
                });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        insertHXData(service);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        insertHXData(service,timeStamp);
        return true;
    }
}

