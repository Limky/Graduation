package zebra.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by multimedia on 2016-05-18.
 */
public class ProductData implements Parcelable{
    public String productName;
    public String description;
    public double starPoint;
    public String productUrl;
    public String barcode;

    @Override
    public int describeContents() {
        return 0;
    }

    public ProductData(){
    }

    public ProductData(Parcel in){
        productName = in.readString();
        description = in.readString();
        productUrl = in.readString();
        starPoint = in.readDouble();
        barcode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(description);
        dest.writeString(productUrl);
        dest.writeDouble(starPoint);
        dest.writeString(barcode);
    }

    public static final Parcelable.Creator<ProductData> CREATOR
            = new Parcelable.Creator<ProductData>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public ProductData createFromParcel(Parcel in) {
            return new ProductData(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public ProductData[] newArray(int size) {
            return new ProductData[size];
        }
    };
}
