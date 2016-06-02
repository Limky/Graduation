package kr.ac.zebra.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import kr.ac.zebra.dao.AppApplyDAO;

@Service
public class AppGcmService {

	private AppApplyDAO appApplyDAO;

	@Autowired
	public void setAppApplyDAO(AppApplyDAO appApplyDAO) {
		this.appApplyDAO = appApplyDAO;
	}

	public boolean pushNotificationToGCM(int applyResult, String barcode) {

		final String GCM_API_KEY = "AIzaSyBW2EMB3DGFKYr-4rq78-fiduOSkPqIb5I";
		final int retries = 3;

		String gcmRegId = appApplyDAO.getTokenId();
		String title = null;
		String message = null;

		if (applyResult == 1) {
			title = "감사합니다";
		} else {
			title = "죄송합니다";
		}

		if (applyResult == 1) {
			message = "요청하신 상품이 등록 완료되었습니다!";
		} else {
			message = "요청하신 상품이 등록 취소되었습니다!";
		}
		Sender sender = new Sender(GCM_API_KEY);
		Message msg = null;
		try {
			msg = new Message.Builder().addData("title", URLEncoder.encode(title, "euc-kr"))
					.addData("message", URLEncoder.encode(message, "euc-kr")).addData("barcode", barcode).build();
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

	public void updateTokenId(String tokenId) {

		appApplyDAO.updateTokenId(tokenId);

	}

}
