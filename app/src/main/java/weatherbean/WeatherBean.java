package weatherbean;

import java.util.List;

public class WeatherBean {
    /**
     * time : 2018-09-22 12:37:21
     * cityInfo : {"city":"天津市","cityId":"101030100","parent":"天津","updateTime":"12:32"}
     * date : 20180922
     * message : Success !
     * status : 200
     * data : {"shidu":"22%","pm25":15,"pm10":46,"quality":"优","wendu":"24","ganmao":"各类人群可自由活动","yesterday":{"date":"21","ymd":"2018-09-21","week":"星期五","sunrise":"05:56","high":"高温 25.0℃","low":"低温 15.0℃","sunset":"18:12","aqi":108,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},"forecast":[{"date":"22","ymd":"2018-09-22","week":"星期六","sunrise":"05:57","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"18:10","aqi":55,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"23","ymd":"2018-09-22","week":"星期日","sunrise":"05:58","high":"高温 23.0℃","low":"低温 14.0℃","sunset":"18:09","aqi":29,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"24","ymd":"2018-09-22","week":"星期一","sunrise":"05:59","high":"高温 24.0℃","low":"低温 15.0℃","sunset":"18:07","aqi":25,"fx":"西北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"25","ymd":"2018-09-22","week":"星期二","sunrise":"06:00","high":"高温 24.0℃","low":"低温 16.0℃","sunset":"18:05","aqi":56,"fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"26","ymd":"2018-09-22","week":"星期三","sunrise":"06:01","high":"高温 24.0℃","low":"低温 17.0℃","sunset":"18:04","aqi":86,"fx":"西南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"}]}
     */

    private String time;
    private CityInfoBean cityInfo;
    private String date;
    private String message;
    private int status;
    private DataBean data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfoBean getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoBean cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class CityInfoBean {
        /**
         * city : 天津市
         * cityId : 101030100
         * parent : 天津
         * updateTime : 12:32
         */

        private String city;
        private String cityId;
        private String parent;
        private String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }

    public static class DataBean {
        /**
         * shidu : 22%
         * pm25 : 15
         * pm10 : 46
         * quality : 优
         * wendu : 24
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"21","ymd":"2018-09-21","week":"星期五","sunrise":"05:56","high":"高温 25.0℃","low":"低温 15.0℃","sunset":"18:12","aqi":108,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}
         * forecast : [{"date":"22","ymd":"2018-09-22","week":"星期六","sunrise":"05:57","high":"高温 26.0℃","low":"低温 15.0℃","sunset":"18:10","aqi":55,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"23","ymd":"2018-09-22","week":"星期日","sunrise":"05:58","high":"高温 23.0℃","low":"低温 14.0℃","sunset":"18:09","aqi":29,"fx":"西北风","fl":"4-5级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"24","ymd":"2018-09-22","week":"星期一","sunrise":"05:59","high":"高温 24.0℃","low":"低温 15.0℃","sunset":"18:07","aqi":25,"fx":"西北风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"25","ymd":"2018-09-22","week":"星期二","sunrise":"06:00","high":"高温 24.0℃","low":"低温 16.0℃","sunset":"18:05","aqi":56,"fx":"西南风","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"26","ymd":"2018-09-22","week":"星期三","sunrise":"06:01","high":"高温 24.0℃","low":"低温 17.0℃","sunset":"18:04","aqi":86,"fx":"西南风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"}]
         */

        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 21
             * ymd : 2018-09-21
             * week : 星期五
             * sunrise : 05:56
             * high : 高温 25.0℃
             * low : 低温 15.0℃
             * sunset : 18:12
             * aqi : 108
             * fx : 西北风
             * fl : 4-5级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String ymd;
            private String week;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 22
             * ymd : 2018-09-22
             * week : 星期六
             * sunrise : 05:57
             * high : 高温 26.0℃
             * low : 低温 15.0℃
             * sunset : 18:10
             * aqi : 55
             * fx : 西北风
             * fl : 4-5级
             * type : 晴
             * notice : 愿你拥有比阳光明媚的心情
             */

            private String date;
            private String ymd;
            private String week;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
