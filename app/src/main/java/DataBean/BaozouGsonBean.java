package DataBean;

import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
/*
* 
* 描    述：暴走大事件gson类
* 作    者：ksheng
* 时    间：2017/2/6$ 22:14$.
*/
public class BaozouGsonBean {
    private int timestamp;
    private List<TopStoriesBean> top_stories;
    private List<DataBean> data;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TopStoriesBean {
        private int document_id;
        private int display_type;
        private int position;
        private String thumbnail;
        private String author_avatar;
        private String author_name;
        private int author_id;
        private int section_id;
        private String title;
        private String image;
        private String url;
        private String share_url;
        private int hit_count;
        private String section_name;
        private String section_image;
        private String section_color;
        private String hit_count_string;
        private int timestamp;
        private int comment_count;
        private int vote_count;

        public int getDocument_id() {
            return document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getAuthor_avatar() {
            return author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public int getSection_id() {
            return section_id;
        }

        public void setSection_id(int section_id) {
            this.section_id = section_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getHit_count() {
            return hit_count;
        }

        public void setHit_count(int hit_count) {
            this.hit_count = hit_count;
        }

        public String getSection_name() {
            return section_name;
        }

        public void setSection_name(String section_name) {
            this.section_name = section_name;
        }

        public String getSection_image() {
            return section_image;
        }

        public void setSection_image(String section_image) {
            this.section_image = section_image;
        }

        public String getSection_color() {
            return section_color;
        }

        public void setSection_color(String section_color) {
            this.section_color = section_color;
        }

        public String getHit_count_string() {
            return hit_count_string;
        }

        public void setHit_count_string(String hit_count_string) {
            this.hit_count_string = hit_count_string;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }
    }

    public static class DataBean {
        /**
         * document_id : 42481
         * display_type : 2
         * title : 浠庡鍏峰埌鏃犱汉鏈猴細涓栫晫涓婇偅浜涘鎬殑绉樺瘑瀹為獙瀹�
         * comment_count : 2
         * vote_count : 0
         * contribute : 0
         * timestamp : 1486389625
         * url : http://mp.weixin.qq.com/s?__biz=MjM5MzE5Mzk2NA==&mid=2651233240&idx=1&sn=4fe7dc7b85548d85052576cd77e0eaf8&chksm=bd68f15b8a1f784de940d276743a5a50ae4efa895d37f5b33e45649387753f99de7557af3d9c&scene=0#wechat_redirect
         * source_name : 绉戞妧鏂板彂鐜�
         * hit_count : 126
         * hit_count_string : 126
         * publish_time : 1486389600000
         * published_at : 2017-02-06 22:00
         * recommenders : [{"id":683361,"name":"Azure","avatar":"http://ww3.sinaimg.cn/large/005PR5erjw1f0nbfi4ltrj305k05ka9y.jpg"}]
         * thumbnail : http://ww1.sinaimg.cn/large/006dGW4Djw1fch3i56f52j3093092q35.jpg
         * author_id : 683361
         * author_name : Azure
         * author_avatar : http://ww3.sinaimg.cn/large/005PR5erjw1f0nbfi4ltrj305k05ka9y.jpg
         * section_id : 6
         * image : http://ww2.sinaimg.cn/large/006u2oRMjw1fcgwkiuq44j30hs0hsgpd.jpg
         * share_url : http://baozouribao.com/documents/42474
         * section_name : 鏆磋蛋澶╁ぉ鐪�
         * section_image : http://ww3.sinaimg.cn/small/0062aa5Kjw1ewkbmqivy0j30f00a0my0.jpg
         * section_color : FF9999
         */

        private int document_id;
        private int display_type;
        private String title;
        private int comment_count;
        private int vote_count;
        private int contribute;
        private int timestamp;
        private String url;
        private String source_name;
        private int hit_count;
        private String hit_count_string;
        private long publish_time;
        private String published_at;
        private String thumbnail;
        private int author_id;
        private String author_name;
        private String author_avatar;
        private int section_id;
        private String image;
        private String share_url;
        private String section_name;
        private String section_image;
        private String section_color;
        private List<RecommendersBean> recommenders;

        public int getDocument_id() {
            return document_id;
        }

        public void setDocument_id(int document_id) {
            this.document_id = document_id;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getContribute() {
            return contribute;
        }

        public void setContribute(int contribute) {
            this.contribute = contribute;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public int getHit_count() {
            return hit_count;
        }

        public void setHit_count(int hit_count) {
            this.hit_count = hit_count;
        }

        public String getHit_count_string() {
            return hit_count_string;
        }

        public void setHit_count_string(String hit_count_string) {
            this.hit_count_string = hit_count_string;
        }

        public long getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(long publish_time) {
            this.publish_time = publish_time;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_avatar() {
            return author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public int getSection_id() {
            return section_id;
        }

        public void setSection_id(int section_id) {
            this.section_id = section_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getSection_name() {
            return section_name;
        }

        public void setSection_name(String section_name) {
            this.section_name = section_name;
        }

        public String getSection_image() {
            return section_image;
        }

        public void setSection_image(String section_image) {
            this.section_image = section_image;
        }

        public String getSection_color() {
            return section_color;
        }

        public void setSection_color(String section_color) {
            this.section_color = section_color;
        }

        public List<RecommendersBean> getRecommenders() {
            return recommenders;
        }

        public void setRecommenders(List<RecommendersBean> recommenders) {
            this.recommenders = recommenders;
        }

        public static class RecommendersBean {
            /**
             * id : 683361
             * name : Azure
             * avatar : http://ww3.sinaimg.cn/large/005PR5erjw1f0nbfi4ltrj305k05ka9y.jpg
             */

            private int id;
            private String name;
            private String avatar;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
