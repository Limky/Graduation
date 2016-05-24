package zebra.manager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import example.zxing.SampleApplication;
import zebra.json.Login;

/**
 * Created by multimedia on 2016-05-24.
 */
public class PropertyManager {

    private static PropertyManager instance;
    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;           // 값을 저장할 때는 Editor

    boolean isLogin = false;

    private PropertyManager() {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(SampleApplication.getContext());
        mEditor = mPrefs.edit();
    }

    public void setAutoLogin(boolean isAutoLogin) {
        mEditor.putBoolean(KEY_AUTO_LOGIN, isAutoLogin);
        mEditor.commit();
    }

    public void setIsogin(boolean isLogin){
        this.isLogin = isLogin;
    }

    public boolean getIsLogin(){
        return isLogin;
    }

    public boolean getAutoLogin(){
        return mPrefs.getBoolean(KEY_AUTO_LOGIN, false);
    }

    public void setMemberInfoToPrefManager(Login result){
        mEditor.putString("id", result.memberData.id);
        mEditor.putString("name", result.memberData.name);
        mEditor.putInt("phoneNumber", result.memberData.phoneNumber);
        mEditor.putInt("point", result.memberData.point);
        mEditor.putInt("level", result.memberData.level);
        mEditor.putString("lastReviewDate", result.memberData.lastReviewDate);
        mEditor.putString("memberUrl", result.memberData.memberUrl);
        mEditor.putInt("reviewCount", result.memberData.reviewCount);
        mEditor.putInt("totalReviewCount", result.memberData.totalReviewCount);
    }

    public void setMemberInfoToMemManager(Login result){
        MemberManager.getInstance().setId(result.memberData.id);
        MemberManager.getInstance().setName(result.memberData.name);
        MemberManager.getInstance().setPhoneNumber(result.memberData.phoneNumber);
        MemberManager.getInstance().setPoint(result.memberData.point);
        MemberManager.getInstance().setLevel(result.memberData.level);
        MemberManager.getInstance().setLastReviewDate(result.memberData.lastReviewDate);
        MemberManager.getInstance().setMemberUrl(result.memberData.memberUrl);
        MemberManager.getInstance().setReviewCount(result.memberData.reviewCount);
        MemberManager.getInstance().setTotalReviewCount(result.memberData.totalReviewCount);
    }

    public void setMemberInfoToMemManager(){
        MemberManager.getInstance().setId(mPrefs.getString("id", null));
        MemberManager.getInstance().setName(mPrefs.getString("name", null));
        MemberManager.getInstance().setPhoneNumber(mPrefs.getInt("phoneNumber", 0));
        MemberManager.getInstance().setPoint(mPrefs.getInt("point", 0));
        MemberManager.getInstance().setLevel(mPrefs.getInt("level", 0));
        MemberManager.getInstance().setLastReviewDate(mPrefs.getString("lastReviewDate", null));
        MemberManager.getInstance().setMemberUrl(mPrefs.getString("memberUrl", null));
        MemberManager.getInstance().setReviewCount(mPrefs.getInt("reviewCount", 0));
        MemberManager.getInstance().setTotalReviewCount(mPrefs.getInt("totalReviewCount", 0));
    }

    public static final String KEY_AUTO_LOGIN = "auto_login";
}
