package mddemo.library.com.activityanimation_master;

import java.util.List;

/**
 * Created by chengcheng on 2015/11/22.
 */
public class JavaBean {

    /**
     * ds : [{"id":"28","title":"小芳姐的金币","shoujia":"200","shuliang":"9100","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"27","title":"小城金币","shoujia":"4000","shuliang":"4000","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"26","title":"小城","shoujia":"12222","shuliang":"12222","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"25","title":"3366","shoujia":"3366","shuliang":"3366","qufu":"山东二区","jiaoyifangshi":"担保        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"24","title":"44","shoujia":"5500","shuliang":"7700","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"55","sid":"66","mid":"77","zhuangtai":"0         ","lianxi":""},{"id":"23","title":"69","shoujia":"6600","shuliang":"6600","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"22","title":"66","shoujia":"6600","shuliang":"6600","qufu":"山东二区","jiaoyifangshi":"担保        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"21","title":"552556","shoujia":"3400","shuliang":"3400","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"20","title":"552556","shoujia":"3400","shuliang":"3400","qufu":"山东二区","jiaoyifangshi":"担保        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""},{"id":"19","title":"5525","shoujia":"3400","shuliang":"3400","qufu":"山东二区","jiaoyifangshi":"寄售        ","shangpinid":"5525682","sid":"666666","mid":"666123","zhuangtai":"0         ","lianxi":""}]
     */

    private List<DsEntity> ds;

    public void setDs(List<DsEntity> ds) {
        this.ds = ds;
    }

    public List<DsEntity> getDs() {
        return ds;
    }

    public static class DsEntity {
        /**
         * id : 28
         * title : 小芳姐的金币
         * shoujia : 200
         * shuliang : 9100
         * qufu : 山东二区
         * jiaoyifangshi : 寄售
         * shangpinid : 5525682
         * sid : 666666
         * mid : 666123
         * zhuangtai : 0
         * lianxi :
         */

        private String id;
        private String title;
        private String shoujia;
        private String shuliang;
        private String qufu;
        private String jiaoyifangshi;
        private String shangpinid;
        private String sid;
        private String mid;
        private String zhuangtai;
        private String lianxi;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setShoujia(String shoujia) {
            this.shoujia = shoujia;
        }

        public void setShuliang(String shuliang) {
            this.shuliang = shuliang;
        }

        public void setQufu(String qufu) {
            this.qufu = qufu;
        }

        public void setJiaoyifangshi(String jiaoyifangshi) {
            this.jiaoyifangshi = jiaoyifangshi;
        }

        public void setShangpinid(String shangpinid) {
            this.shangpinid = shangpinid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public void setZhuangtai(String zhuangtai) {
            this.zhuangtai = zhuangtai;
        }

        public void setLianxi(String lianxi) {
            this.lianxi = lianxi;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getShoujia() {
            return shoujia;
        }

        public String getShuliang() {
            return shuliang;
        }

        public String getQufu() {
            return qufu;
        }

        public String getJiaoyifangshi() {
            return jiaoyifangshi;
        }

        public String getShangpinid() {
            return shangpinid;
        }

        public String getSid() {
            return sid;
        }

        public String getMid() {
            return mid;
        }

        public String getZhuangtai() {
            return zhuangtai;
        }

        public String getLianxi() {
            return lianxi;
        }
    }
}
