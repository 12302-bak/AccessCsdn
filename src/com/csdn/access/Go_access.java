package com.csdn.access;



import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Go_access {
	private String prior = "http://blog.csdn.net";

	private String strLink = null;
	StringBuffer stbu = new StringBuffer();

  public synchronized void go_access_link (List<String> list) {
		
		for (int i = 0; i < list.size(); i++) {
			strLink=prior.concat(list.get(i));
			System.out.println("accessing£º"+strLink);
			try {
				URL url = new URL(strLink);
				URLConnection con = url.openConnection();
				con.setConnectTimeout(5000);
				con.setDoInput(true);
				((HttpURLConnection) con).setRequestMethod("GET");
				System.out.println("ResponseCode£º"+((HttpURLConnection) con).getResponseCode());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
