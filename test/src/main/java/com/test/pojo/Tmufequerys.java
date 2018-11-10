/**
  * Copyright 2018 bejson.com 
  */
package com.test.pojo;
import java.util.List;

/**
 * Auto-generated: 2018-09-18 10:52:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Tmufequerys {

    private List<Categories> categories;
    private long ttl;
    private String url;
    private int wrsscore;
    public void setCategories(List<Categories> categories) {
         this.categories = categories;
     }
     public List<Categories> getCategories() {
         return categories;
     }

    public void setTtl(long ttl) {
         this.ttl = ttl;
     }
     public long getTtl() {
         return ttl;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setWrsscore(int wrsscore) {
         this.wrsscore = wrsscore;
     }
     public int getWrsscore() {
         return wrsscore;
     }

}