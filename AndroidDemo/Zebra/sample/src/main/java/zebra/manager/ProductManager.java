package zebra.manager;

/**
 * Created by multimedia on 2016-05-23.
 */
public class ProductManager {
    public static ProductManager instance;
    public static ProductManager getInstance(){
        if(instance == null){
            instance = new ProductManager();
        }
        return instance;
    }
}
