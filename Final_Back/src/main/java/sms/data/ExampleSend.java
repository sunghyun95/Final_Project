package sms.data;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class ExampleSend {
	public void sendSms(String msg, String phone,String adminhp)
	{
		String api_key = "NCSMIEC1QLBR0KUW";
	    String api_secret = "2XYGSJVXVFJNT6PAOK2Y3MYL4OAPZJFP";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phone); //�޴»��
	    params.put("from", "010-3090-9685"); //������ ���
	    params.put("type", "SMS");
	    params.put("text", msg);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
}

