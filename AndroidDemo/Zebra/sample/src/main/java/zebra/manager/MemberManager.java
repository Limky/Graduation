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
    private MemberManager(){}

    String id;
    String name;
    int phoneNumber;
    int point;
    int level;
    String lastReviewDate;
    int reviewCount;
    int totalReviewCount;

    public String getId(){
        return this.id;
    }
}
