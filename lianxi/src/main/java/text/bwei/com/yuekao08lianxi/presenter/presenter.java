package text.bwei.com.yuekao08lianxi.presenter;

import java.util.List;

import text.bwei.com.yuekao08lianxi.bean.News;
import text.bwei.com.yuekao08lianxi.model.Imodel;
import text.bwei.com.yuekao08lianxi.model.OnselectLick;
import text.bwei.com.yuekao08lianxi.model.model;
import text.bwei.com.yuekao08lianxi.view.Iview;

/**
 * Created by dell on 2017/11/23.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getOk(String url) {
        imodel.RequestSuccess(url, new OnselectLick() {
            @Override
            public void dataSuccess(List<News.DataBean> list) {
                iview.showSuccess(list);


            }

            @Override
            public void dataErrror(String s) {

            }
        });


    }


}
