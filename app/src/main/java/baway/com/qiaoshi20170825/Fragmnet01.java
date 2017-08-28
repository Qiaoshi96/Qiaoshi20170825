package baway.com.qiaoshi20170825;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by qiaoshi on 2017/8/25.
 */

public class Fragmnet01 extends Fragment {
    private List<Data.QsBean> list;
    private XRecyclerView xRecyclerView;
    private String string;
    private String path="http://139.196.140.118:8080/get/%7B%22%5B%5D%22:%7B%22page%22:0,%22count%22:10,%22Moment%22:%7B%22content$%22:%22%2525a%2525%22%7D,%22User%22:%7B%22id@%22:%22%252FMoment%252FuserId%22,%22@column%22:%22id,name,head%22%7D,%22Comment%5B%5D%22:%7B%22count%22:2,%22Comment%22:%7B%22momentId@%22:%22%5B%5D%252FMoment%252Fid%22%7D%7D%7D%7D";
    private  RecyclerViewAdapter adapter;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmnet01, container, false);
        xRecyclerView=view.findViewById(R.id.xrec);
        list=new ArrayList<>();
//        加载
       adapter = new RecyclerViewAdapter(list, getActivity());
        manager = new LinearLayoutManager(getActivity());
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setAdapter(adapter);
        getMessage();

        xRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int endCompletelyPosition = manager.
                        findLastCompletelyVisibleItemPosition();
                if (endCompletelyPosition == manager.getItemCount() - 1) {
                    getMessage();
                    Toast.makeText(getActivity(),"刷新成功！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
//    获取数据的方法
    public  void getMessage(){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {


            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                           得到的结果
                        Gson gson = new Gson();
                        Data data = gson.fromJson(string, Data.class);
                        list.addAll(data.zwl);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
