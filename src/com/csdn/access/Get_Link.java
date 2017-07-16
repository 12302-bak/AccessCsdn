package com.csdn.access;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Get_Link {
     private String myblog="http://blog.csdn.net/xhs_12302?viewmode=contents";
     private String strHtml=null;
     StringBuffer stbu=new StringBuffer();
     
     
     public List<String> get_link_list(){
    	 InputStream in=null;
    	 InputStreamReader ir = null;
    	 BufferedReader br=null;
    	 URLConnection con;
    	 try {
    		 URL url=new URL(myblog);
        	 con=url.openConnection();
        	 con.setConnectTimeout(5000);
        	 con.setDoInput(true);
        	 ((HttpURLConnection) con).setRequestMethod("GET");
        	 int RequestCode=((HttpURLConnection) con).getResponseCode();

        	 if(RequestCode==200){
        		 in=con.getInputStream();
        	 }
        	 ir= new InputStreamReader(in);
        	 br=new BufferedReader(ir);
        	 String str=null;
        	 while((str=br.readLine())!=null){
        		 stbu.append(str);
        	 }
        	 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				in.close();
				ir.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
    	 
    	 strHtml=stbu.toString();
    	 return anaylze(strHtml);
     	
     }
     public List<String> anaylze(String str){
    	 List<String> listUrl=new ArrayList<String>();
    	 String linkUrl="/xhs_12302/article/details/\\d{8}";
    	 Pattern p=Pattern.compile(linkUrl);
    	 Matcher m=p.matcher(str);
    	 while(m.find()){
    		 
    		 if(!listUrl.contains(m.group())){
    			 listUrl.add(m.group());
    		 }
    	 }
    	 return listUrl;
     }
}
