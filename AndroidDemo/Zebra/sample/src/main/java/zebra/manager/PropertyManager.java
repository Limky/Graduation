package zebra.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import example.zxing.SampleApplication;
import zebra.json.Login;

/**
 * Created by multimedia on 2016-05-24.
 */
public class PropertyManager{

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
    }

    public void setAutoLogin(Context context, boolean isAutoLogin) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
        mEditor.putBoolean(KEY_AUTO_LOGIN, isAutoLogin);
        mEditor.commit();
    }

    public void setIsLogin(boolean isLogin){
        this.isLogin = isLogin;
    }

    public boolean getIsLogin(){
        return isLogin;
    }

    public boolean getAutoLogin(Context context){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        return mPrefs.getBoolean(KEY_AUTO_LOGIN, false);
    }

    public void setMemberInfoToPrefManager(Login result){
        mEditor.putString("id", result.member.id);
        mEditor.putString("name", result.member.name);
        mEditor.putString("phoneNumber", result.member.phoneNumber);
        mEditor.putInt("point", result.member.point);
        mEditor.putString("level", result.member.level);
        mEditor.putString("lastReviewDate", result.member.lastReviewDate);
        mEditor.putString("memberUrl", result.member.memberUrl);
        mEditor.putInt("reviewCount", result.member.reviewCount);
        mEditor.putInt("totalReviewCount", result.member.totalReviewCount);
    }

    public void setMemberInfoToMemManager(Login result){
        MemberManager.getInstance().setId(result.member.id);
        MemberManager.getInstance().setName(result.member.name);
        MemberManager.getInstance().setPhoneNumber(result.member.phoneNumber);
        MemberManager.getInstance().setPoint(result.member.point);
        MemberManager.getInstance().setLevel(result.member.level);
        MemberManager.getInstance().setLastReviewDate(result.member.lastReviewDate);
        MemberManager.getInstance().setMemberUrl(result.member.memberUrl);
        MemberManager.getInstance().setReviewCount(result.member.reviewCount);
        MemberManager.getInstance().setTotalReviewCount(result.member.totalReviewCount);
        //MemberManager.getInstance().setIsLogin(true);
    }

    public void setMemberInfoToMemManager(){
        MemberManager.getInstance().setId(mPrefs.getString("id", null));
        MemberManager.getInstance().setName(mPrefs.getString("name", null));
        MemberManager.getInstance().setPhoneNumber(mPrefs.getString("phoneNumber", null));
        MemberManager.getInstance().setPoint(mPrefs.getInt("point", 0));
        int i = mPrefs.getInt("point", 0);
        MemberManager.getInstance().setLevel(mPrefs.getString("level", null));
        MemberManager.getInstance().setLastReviewDate(mPrefs.getString("lastReviewDate", null));
        MemberManager.getInstance().setMemberUrl(mPrefs.getString("memberUrl", null));
        MemberManager.getInstance().setReviewCount(mPrefs.getInt("reviewCount", 0));
        MemberManager.getInstance().setTotalReviewCount(mPrefs.getInt("totalReviewCount", 0));
        MemberManager.getInstance().setIsLogin(true);
    }

    public void setLogOut(){
        if(mPrefs == null)return;
        MemberManager.getInstance().clearMemberInfo();
        mEditor.putString("id", "");
        mEditor.putString("name", "");
        mEditor.putString("phoneNumber", "");
        mEditor.putInt("point", 0);
        mEditor.putString("level", "");
        mEditor.putString("lastReviewDate", "");
        mEditor.putString("memberUrl", "");
        mEditor.putInt("reviewCount", 0);
        mEditor.putInt("totalReviewCount", 0);
        mEditor.commit();
    }

    public static final String KEY_AUTO_LOGIN = "auto_login";
}