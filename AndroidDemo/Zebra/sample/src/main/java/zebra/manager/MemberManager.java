package zebra.manager;

import java.util.List;

import zebra.data.ReviewData;
import zebra.json.Login;
import zebra.json.MyReview;
import zebra.json.Review;

/**
 * Created by multimedia on 2016-05-21.
 */
public class MemberManager {
    private static MemberManager instance;
    public static MemberManager getInstance(){
        if(instance == null){
            instance = new MemberManager();
        }
        return instance;
    }

    private MemberManager(){

    }

    public void memberSet(Login result){
        id = result.member.id;
        name = result.member.name;
        phoneNumber = result.member.phoneNumber;
        point = result.member.point;
        level = result.member.level;
        lastReviewDate = result.member.lastReviewDate;
        memberUrl = result.member.memberUrl;
        reviewCount = result.member.reviewCount;
        totalReviewCount = result.member.totalReviewCount;
        isLogin = true;
    }

    String id;
    String name;
    String phoneNumber;
    int point;
    String level;
    String lastReviewDate;
    String memberUrl;
    int reviewCount;
    int totalReviewCount;
    boolean isLogin;

    public MyReview reviews;

    public void setReviews (MyReview review){
        this.reviews = review;
    }

    public MyReview getReviews(){
        return reviews;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(String lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public String getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(String memberUrl) {
        this.memberUrl = memberUrl;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getTotalReviewCount() {
        return totalReviewCount;
    }

    public void setTotalReviewCount(int totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }

    public String getId(){
        return this.id;
    }

    public void clearMemberInfo(){
        String id = null;
        String name = null;
        String phoneNumber = null;
        int point = 0;
        String level = null;
        String lastReviewDate = null;
        String memberUrl = null;
        int reviewCount = 0;
        int totalReviewCount = 0;
        setIsLogin(false);
    }

    public boolean getIsLogin(){
        return isLogin;
    }

    public void setIsLogin(boolean isLogin){
        this.isLogin = isLogin;
    }
}
