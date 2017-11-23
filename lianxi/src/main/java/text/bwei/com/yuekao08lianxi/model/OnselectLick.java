package text.bwei.com.yuekao08lianxi.model;

import java.util.List;

import text.bwei.com.yuekao08lianxi.bean.News;

/**
 * Created by dell on 2017/11/23.
 */

public interface OnselectLick {
    void dataSuccess(List<News.DataBean> list);
    void dataErrror(String s);

}
