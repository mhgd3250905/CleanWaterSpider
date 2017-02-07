package MyFragment;

import DataBean.BaozouGsonBean;
import DataBean.BaozouVideoGsonBean;
import DataBean.BaseGsonBean;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2016/12/2.
 */
/*
* 
* 描    述：
* 作    者：ksheng
* 时    间：2016/12/2$ 21:48$.
*/
public interface WebService {

//    https://api.bmob.cn/1/classes/TableName
    @Headers({
            "X-Bmob-Application-Id: 9e16e39fa5374f446e5c928da0f83d62",
            "X-Bmob-REST-API-Key: 42db163cd4c45884279b914e1c2a4e75",
            "Content-Type: application/json"
    })
    @GET("1/classes/{tableName}")
    Observable<BaseGsonBean> getHXGsonData(@Path("tableName")String tableName,
                                           @Query("limit")String limit, @Query("skip") String skip,
                                           @Query("order")String order);

    //获取暴走日报首页内容
    @GET("api/v31/documents/latest")
    Observable<BaozouGsonBean> getBaozouGsonBean();

    //获取暴走日报首页内容
    @GET("api/v31/documents/latest")
    Observable<BaozouGsonBean> getNextBaozouGsonBean(@Query("timestamp")int timestamp);

    //获取暴走日报视频内容
    @GET("api/v31/documents/videos/latest")
    Observable<BaozouVideoGsonBean> getBaozouVideoGsonBean();

    //获取暴走日报首页内容
    @GET("api/v31/documents/videos/latest")
    Observable<BaozouVideoGsonBean> getNextBaozouVideoGsonBean(@Query("timestamp")int timestamp);

}