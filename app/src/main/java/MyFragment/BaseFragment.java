package MyFragment;

import android.annotation.SuppressLint;
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
import DataBean.BaseBean;
import DataBean.NewsGsonBean;
import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bmob.v3.Bmob;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import skkk.cleanwaterinformation.R;
import skkk.cleanwaterinformation.WebContentActivity;

/**
 * Created by admin on 2016/11/21.
 */
/*
* 
* 描    述：展示虎嗅网的Fragment
* 作    者：ksheng
* 时    间：2016/11/21$ 21:16$.
*/
@SuppressLint("ValidFragment")
public class BaseFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate{
    private static final String TAG = "BaseFragment";

    @Bind(R.id.rv_huxiu)
    RecyclerView rvData;
    @Bind(R.id.rv_refresh)
    BGARefreshLayout mRefreshLayout;



    private List<BaseBean> mDataList=new ArrayList<BaseBean>();
    private BaseAdapter adapter;
    private Retrofit retrofit;

    private static final String BASE_URL="http://www.ixiaobai.xyz/";
    private WebService service;
    private String tableName;
    private int limit=20;
    private int skip=20;
    private int page=0;

    @SuppressLint("ValidFragment")
    public BaseFragment(String tableName) {
        this.tableName = tableName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bmob.initialize(getContext(), "9e16e39fa5374f446e5c928da0f83d62");
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
//                Intent itemIntent=new Intent();
//                itemIntent.putExtra("url",mDataList.get(position).getContentURL());
//                itemIntent.putExtra("title",mDataList.get(position).getTitle()
//                        .replace("\uE40B"," ").replace("\uE40A"," "));
//                itemIntent.setClass(getContext(), WebActivity.class);
//                startActivity(itemIntent);

                Intent itemIntent=new Intent();
                itemIntent.putExtra("content",mDataList.get(position).getContent());
                itemIntent.putExtra("title",mDataList.get(position).getTitle()
                        .replace("\uE40B"," ").replace("\uE40A"," "));
                itemIntent.setClass(getContext(), WebContentActivity.class);
                startActivity(itemIntent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    public void insertHXData(WebService service) {
//        service.getIXiaobaiData(tableName,page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "onNext() called with: s = [" + s + "]");
//                    }
//                });

        service.getIXiaobaiData(tableName,page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsGsonBean, List<BaseBean>>() {
                    @Override
                    public List<BaseBean> call(NewsGsonBean newsBean) {
                        List<BaseBean> dataList=new ArrayList<>();
                        if (newsBean.getError()==0){
                            for (int i = 0; i < newsBean.getNews().size(); i++) {
                                BaseBean item=new BaseBean();
                                item.setTitle(newsBean.getNews().get(i).getPayload().getTitle());
                                item.setContentURL(newsBean.getNews().get(i).getPayload().getUrl());
                                item.setImgSrc(newsBean.getNews().get(i).getPayload().getImgSrc());
                                item.setContent(newsBean.getNews().get(i).getPayload().getContent());
                                dataList.add(item);
                            }
                        }
                        return dataList;
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
                    public void onNext(List<BaseBean> newsList) {
//                        LogUtils.Log(huXiuList.size()+"");
                        adapter.append(newsList);
                    }
                });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        insertHXData(service);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        page++;
        insertHXData(service);
        return true;
    }
}
