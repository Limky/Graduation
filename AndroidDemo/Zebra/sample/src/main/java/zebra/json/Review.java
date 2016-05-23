package zebra.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import zebra.data.ProductData;
import zebra.data.ReviewData;

/**
 * Created by multimedia on 2016-05-21.
 */
public class Review implements Parcelable{
    public List<ReviewData> reviews;
    public ProductData productInfo;

    @Override
    public int describeContents() {
        return 0;
    }
    public Review(Parcel in){
        productInfo = in.readParcelable(Review.class.getClassLoader());
        reviews = new ArrayList<ReviewData>();
        in.readList(reviews, getClass().getClassLoader());
    }
    public Review(){
        productInfo = new ProductData();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(productInfo, flags);
        dest.writeList(reviews);
    }

    public static final Parcelable.Creator<Review> CREATOR
            = new Parcelable.Creator<Review>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}