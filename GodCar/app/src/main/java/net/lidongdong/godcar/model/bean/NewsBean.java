package net.lidongdong.godcar.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻页
 */
public class NewsBean {


    private ResultBean result;


    private int returncode;
    private String message;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ResultBean {
        private int rowcount;
        private boolean isloadmore;
        private List<?> focusimg;
        /**
         * dbid : 0
         * id : 893417
         * title : Faraday Future首款量产车最新谍照曝光
         * mediatype : 0
         * type : 新闻中心
         * time : 2016-09-21
         * intacttime : 2016/9/21 8:19:26
         * indexdetail :
         * smallpic : http://www3.autoimg.cn/newsdfs/g4/M08/4C/AC/400x300_0_autohomecar__wKgHy1fhBe6AV6N0AAHEbfkME-8699.jpg
         * replycount : 5
         * pagecount : 1
         * jumppage : 1
         * lasttime : 20160921081926893417
         * newstype : 0
         * updatetime : 20160921081828
         */

        private List<NewslistBean> newslist;

        public int getRowcount() {
            return rowcount;
        }

        public void setRowcount(int rowcount) {
            this.rowcount = rowcount;
        }

        public boolean isIsloadmore() {
            return isloadmore;
        }

        public void setIsloadmore(boolean isloadmore) {
            this.isloadmore = isloadmore;
        }

        public List<?> getFocusimg() {
            return focusimg;
        }

        public void setFocusimg(List<?> focusimg) {
            this.focusimg = focusimg;
        }

        public List<NewslistBean> getNewslist() {
            return newslist;
        }

        public void setNewslist(List<NewslistBean> newslist) {
            this.newslist = newslist;
        }

        public static class NewslistBean {
            private int dbid;
            private int id;
            private String title;
            private int mediatype;
            private String type;
            private String time;
            private String intacttime;
            private String indexdetail;
            private String smallpic;
            private int replycount;
            private int pagecount;
            private int jumppage;
            private String lasttime;
            private int newstype;
            private String updatetime;

            public int getDbid() {
                return dbid;
            }

            public void setDbid(int dbid) {
                this.dbid = dbid;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMediatype() {
                return mediatype;
            }

            public void setMediatype(int mediatype) {
                this.mediatype = mediatype;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getIntacttime() {
                return intacttime;
            }

            public void setIntacttime(String intacttime) {
                this.intacttime = intacttime;
            }

            public String getIndexdetail() {
                return indexdetail;
            }

            public void setIndexdetail(String indexdetail) {
                this.indexdetail = indexdetail;
            }

            public String getSmallpic() {
                return smallpic;
            }

            public void setSmallpic(String smallpic) {
                this.smallpic = smallpic;
            }

            public int getReplycount() {
                return replycount;
            }

            public void setReplycount(int replycount) {
                this.replycount = replycount;
            }

            public int getPagecount() {
                return pagecount;
            }

            public void setPagecount(int pagecount) {
                this.pagecount = pagecount;
            }

            public int getJumppage() {
                return jumppage;
            }

            public void setJumppage(int jumppage) {
                this.jumppage = jumppage;
            }

            public String getLasttime() {
                return lasttime;
            }

            public void setLasttime(String lasttime) {
                this.lasttime = lasttime;
            }

            public int getNewstype() {
                return newstype;
            }

            public void setNewstype(int newstype) {
                this.newstype = newstype;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
