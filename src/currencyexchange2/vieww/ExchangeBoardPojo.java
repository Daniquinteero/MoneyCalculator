package currencyexchange2.vieww;

import com.google.gson.annotations.SerializedName;

public class ExchangeBoardPojo {
    public Motd motd;
    public boolean success;
    public Query query;
    public Info info;
    
    public static class Motd {
        @SerializedName("msg")
        public String message;
        public String url;
        
    }
    
    public static class Query {
        public String from;
        public String to;
        public String amount;
    }
    
    public static class Info {
        public double rate;
    }
}
