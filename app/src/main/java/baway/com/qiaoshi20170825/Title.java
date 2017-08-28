package baway.com.qiaoshi20170825;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * qiaoshi
 */

public class Title extends RelativeLayout{
//    创建自定义布局
    public Title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.zidingyi,this);
        TextView textView=findViewById(R.id.textView);
//        设置自定义属性
        if (attrs!=null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Title);
            int color = array.getColor(R.styleable.Title_Title_name, Color.WHITE);//颜色
            textView.setTextColor(color);
            array.recycle();
        }
    }
//B．标题控件中间标题内容支持自定义属性（10分）
}
