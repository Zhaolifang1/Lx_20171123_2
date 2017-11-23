package text.bwei.com.yuekao08lianxi.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.yuekao08lianxi.Api.ApiServer;
import text.bwei.com.yuekao08lianxi.bean.News;

/**
 * Created by dell on 2017/11/23.
 */

public class model implements Imodel {
    @Override
    public void RequestSuccess(String url, final OnselectLick onselectLick) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<News> data = apiServer.getData();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BannerBean>() {
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news) {
                        List<News.DataBean> data1 = news.getData();
                        onselectLick.dataSuccess(data1);
                    }
                });


    }
}
