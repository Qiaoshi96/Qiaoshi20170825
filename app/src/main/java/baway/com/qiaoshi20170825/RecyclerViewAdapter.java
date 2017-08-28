package baway.com.qiaoshi20170825;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Data.QsBean> list;
    private Context context;

    //回传参数
    public RecyclerViewAdapter(List<Data.QsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //绘制视图
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item, parent,
                false));
        return holder;
    }

    //绑定视图
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data.QsBean bean = list.get(position);
        holder.title.setText(bean.Moment.content);
        holder.time.setText(bean.Moment.date);
        holder.good.setText(bean.Commentzwl.get(0).momentId + "点赞");
        holder.say.setText(bean.Commentzwl.get(0).toId + "评论");
//        bean.Moment.pictureList.get(0)
//        bean.User.head
        Glide.with(context).load(bean.User.head).into(holder.itemImage);
        Glide.with(context).load( bean.Moment.pictureList.get(0)).into(holder.contentImage1);
        Glide.with(context).load( bean.Moment.pictureList.get(0)).into(holder.contentImage2);
        Glide.with(context).load( bean.Moment.pictureList.get(0)).into(holder.contentImage3);
    }

    //recyclerview的条目数
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title, good, say, time;
        private ImageView itemImage, contentImage1, contentImage2, contentImage3;

        //定义viewholder
        public MyViewHolder(View view) {
            super(view);
            itemImage =  view.findViewById(R.id.item_image);
            contentImage1 = view.findViewById(R.id.item_content_image1);
            contentImage2 =  view.findViewById(R.id.item_content_image2);
            contentImage3 =  view.findViewById(R.id.item_content_image3);
            title =  view.findViewById(R.id.item_title);
            time = view.findViewById(R.id.item_time);
            good =  view.findViewById(R.id.item_good);
            say =  view.findViewById(R.id.item_say);
        }
    }
}
