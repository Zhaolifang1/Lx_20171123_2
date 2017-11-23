package text.bwei.com.yuekao08lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import text.bwei.com.yuekao08lianxi.Api.Api;
import text.bwei.com.yuekao08lianxi.adapter.MyAdapter;
import text.bwei.com.yuekao08lianxi.bean.MyString;
import text.bwei.com.yuekao08lianxi.bean.News;
import text.bwei.com.yuekao08lianxi.presenter.presenter;
import text.bwei.com.yuekao08lianxi.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;
    private text.bwei.com.yuekao08lianxi.presenter.presenter presenter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new presenter(this);
        presenter.getOk(Api.URL);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
    }


    @Override
    public void showSuccess(final List<News.DataBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnClickLisener(new MyAdapter.OnClickLisener() {
            @Override
            public void OnDainji(View v, int position) {

                EventBus.getDefault().postSticky(new MyString(list.get(position).getVedio_url()));
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
//                intent.putExtra("url", list.get(position).getVedio_url());
                startActivity(intent);
            }

            @Override
            public void OnLong(View v, int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
               intent.putExtra("mm",list.get(position).getVedio_url());
                startActivity(intent);

            }
        });

    }

    @Override
    public void showError(String s) {

    }
}
