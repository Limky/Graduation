package zebra.manager;

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

    String id;
    String name;
    String phoneNumber;
    int point;
    String level;
    String lastReviewDate;
    String memberUrl;
    int reviewCount;
    int totalReviewCount;

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

    public void setMember(){

    }
}
