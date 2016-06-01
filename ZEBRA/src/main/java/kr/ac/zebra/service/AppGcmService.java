package kr.ac.zebra.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Service
public class AppGcmService {

   public boolean pushNotificationToGCM() {
      final String GCM_API_KEY = "AIzaSyBW2EMB3DGFKYr-4rq78-fiduOSkPqIb5I";
      final int retries = 3;
      String gcmRegId = "eGZ5QHoYjJE:APA91bF5JuHWTxIwWHEDubCP0X9Eu0wsxfpL5rOWGYF33-9l5uvL9nOoxfoBj67jw7x_PmjwhwBo8zZIW6jjgi8i9cTt_O7uKYRjKtzorEqiqvosrflODjl-TsOmHMkrw2vh40rUhDo0";
      String title = "ZEBRA";
      String message = "안녕하세요!! 제가 메인 Activity에서 다른 activity 로 화면을 전환 하려고 합니다. 근데 아무리해도 안되네요 ㅠㅠ 버튼을 눌렀을때 화면이 전환 되도록 하는 건데요... buttonChat = (Button) findViewById(R.id.chat); b...  ";
      Sender sender = new Sender(GCM_API_KEY);
      Message msg = null;
      try {
         msg = new Message.Builder().addData("title", URLEncoder.encode(title, "euc-kr"))
               .addData("message", URLEncoder.encode(message, "euc-kr")).build();
      } catch (UnsupportedEncodingException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }

      try {
         if (gcmRegId != null) {
            Result result = sender.send(msg, gcmRegId, retries);

            if (StringUtils.isEmpty(result.getErrorCodeName())) {
               System.out.println("GCM Notification is sent successfully" + result.toString());
               return true;
            }

            System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName());

         }
      } catch (InvalidRequestException e) {
         System.out.println("Invalid Request");
      } catch (IOException e) {
         System.out.println("IO Exception");
      }
      return false;

   }

}
