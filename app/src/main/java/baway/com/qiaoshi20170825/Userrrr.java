package baway.com.qiaoshi20170825;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class Userrrr {

    /**
     * data : [{"Comment":[{"content":"This is a Content...-3","date":"2017-02-01 19:20:50.0","id":3,"momentId":15,"toId":0,"userId":82002},{"content":"thank you","date":"2017-03-25 20:28:03.0","id":176,"momentId":15,"toId":166,"userId":38710}],"Moment":{"content":"APIJSON is a JSON Transmission Structure Protocol\u2026","date":"2017-02-08 16:06:11.0","id":15,"pictureList":["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"],"praiseUserIdList":[82055,82002,82001],"userId":70793},"User":{"head":"http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000","id":70793,"name":"Strong"}}]
     * code : 200
     * msg : success
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


    public static class DataBean {
        /**
         * Comment : [{"content":"This is a Content...-3","date":"2017-02-01 19:20:50.0","id":3,"momentId":15,"toId":0,"userId":82002},{"content":"thank you","date":"2017-03-25 20:28:03.0","id":176,"momentId":15,"toId":166,"userId":38710}]
         * Moment : {"content":"APIJSON is a JSON Transmission Structure Protocol\u2026","date":"2017-02-08 16:06:11.0","id":15,"pictureList":["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"],"praiseUserIdList":[82055,82002,82001],"userId":70793}
         * User : {"head":"http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000","id":70793,"name":"Strong"}
         */

        private MomentBean Moment;
        private UserBean User;
        private List<CommentBean> Comment;

        public MomentBean getMoment() {
            return Moment;
        }

        public void setMoment(MomentBean Moment) {
            this.Moment = Moment;
        }

        public UserBean getUser() {
            return User;
        }

        public void setUser(UserBean User) {
            this.User = User;
        }

        public List<CommentBean> getComment() {
            return Comment;
        }

        public void setComment(List<CommentBean> Comment) {
            this.Comment = Comment;
        }



        public static class MomentBean {
            /**
             * content : APIJSON is a JSON Transmission Structure Protocol…
             * date : 2017-02-08 16:06:11.0
             * id : 15
             * pictureList : ["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"]
             * praiseUserIdList : [82055,82002,82001]
             * userId : 70793
             */

            private String content;
            private String date;
            private int id;
            private int userId;
            private List<String> pictureList;
            private List<Integer> praiseUserIdList;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public List<String> getPictureList() {
                return pictureList;
            }

            public void setPictureList(List<String> pictureList) {
                this.pictureList = pictureList;
            }

            public List<Integer> getPraiseUserIdList() {
                return praiseUserIdList;
            }

            public void setPraiseUserIdList(List<Integer> praiseUserIdList) {
                this.praiseUserIdList = praiseUserIdList;
            }
        }

        public static class UserBean {
            /**
             * head : http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000
             * id : 70793
             * name : Strong
             */

            private String head;
            private int id;
            private String name;

            public String getHead() {
                return head;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class CommentBean {
            /**
             * content : This is a Content...-3
             * date : 2017-02-01 19:20:50.0
             * id : 3
             * momentId : 15
             * toId : 0
             * userId : 82002
             */

            private String content;
            private String date;
            private int id;
            private int momentId;
            private int toId;
            private int userId;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMomentId() {
                return momentId;
            }

            public void setMomentId(int momentId) {
                this.momentId = momentId;
            }

            public int getToId() {
                return toId;
            }

            public void setToId(int toId) {
                this.toId = toId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
