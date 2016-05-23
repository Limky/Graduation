package zebra.manager;

/**
 * Created by multimedia on 2016-05-21.
 */
public class ScanManager {
    private static ScanManager instance;

    public static ScanManager getInstance() {
        if (instance == null) {
            instance = new ScanManager();
        }
        return instance;
    }

    private String barcode;
    private String productUrl;

    private ScanManager() {
        barcode = null;
        productUrl = null;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getProductUrl() { return productUrl; }

    public void setProductUrl(String productUrl) { this.productUrl = productUrl; }
}
