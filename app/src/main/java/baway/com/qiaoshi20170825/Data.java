package baway.com.qiaoshi20170825;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author: qiaoshi
 * data: 2017/8/25.
 * desc:bean类
 */

public class Data {

    public long code;
    public String msg;
    @SerializedName("[]")
    public List<QsBean> zwl;

    public static class QsBean {

        public MomentBean Moment;
        public UserBean User;

        @SerializedName("Comment[]")
        public List<CommentzwlBean> Commentzwl;

        public static class MomentBean {
            public long id;
            public long userId;
            public String date;
            public String content;
            public List<Long> praiseUserIdList;
            public List<String> pictureList;
        }

        public static class UserBean {
            public long id;
            public String name;
            public String head;
        }

        public static class CommentzwlBean {

            public long id;
            public long toId;
            public long userId;
            public long momentId;
            public String date;
            public String content;

//            public static CommentzwlBean objectFromData(String str) {
//                return new Gson().fromJson(str, CommentzwlBean.class);
//            }
        }

        public static class Comment {
            public long id;
            public long toId;
            public long userId;
            public long momentId;
            public String date;
            public String content;
        }
    }
}
