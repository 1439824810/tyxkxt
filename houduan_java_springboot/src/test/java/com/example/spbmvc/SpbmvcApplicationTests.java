package com.example.spbmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@SpringBootTest
class SpbmvcApplicationTests {

	@Test
	public void test()throws Exception{
		String urlStr = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wwfce60765bbd07487&corpsecret=60IvI6D2cO1iqpnJ4Rc9Hc9faNHJpael06omUDcuP5I";
		URL url = new URL(urlStr);
		URLConnection urlConnection =url.openConnection();
		HttpURLConnection httpURLConnection =(HttpURLConnection) urlConnection;
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Accept-Charset","utf-8");
		try{
			InputStream inputStream =httpURLConnection.getInputStream();
			InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
			BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
			String line;
			while ((line =bufferedReader.readLine())!=null){
				System.out.println(line);
			}
		}catch (Exception e){

		}finally {

		}
	}

}
