package DataBean;

import java.util.List;

/**
 * 创建于 2018/4/16
 * 作者 admin
 */

public class NewsGsonBean {

    private int error;
    private List<NewsBean> news;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class NewsBean {

        private String Url;
        private String Type;
        private String Id;
        private PayloadBean Payload;

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public PayloadBean getPayload() {
            return Payload;
        }

        public void setPayload(PayloadBean Payload) {
            this.Payload = Payload;
        }

        public static class PayloadBean {

            private String Title;
            private String Url;
            private String ImgSrc;
            private String TimeGap;
            private String Desc;
            private String Content;
            private String Author;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public String getImgSrc() {
                return ImgSrc;
            }

            public void setImgSrc(String ImgSrc) {
                this.ImgSrc = ImgSrc;
            }

            public String getTimeGap() {
                return TimeGap;
            }

            public void setTimeGap(String TimeGap) {
                this.TimeGap = TimeGap;
            }

            public String getDesc() {
                return Desc;
            }

            public void setDesc(String Desc) {
                this.Desc = Desc;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public String getAuthor() {
                return Author;
            }

            public void setAuthor(String Author) {
                this.Author = Author;
            }
        }
    }
}
