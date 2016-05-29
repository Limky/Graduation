package zebra.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import zebra.data.ProductData;
import zebra.data.ReviewData;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReview implements Parcelable{
    public List<ReviewData> reviews;

    @Override
    public int describeContents() {
        return 0;
    }
    public MyReview(Parcel in){
        reviews = new ArrayList<ReviewData>();
        in.readList(reviews, getClass().getClassLoader());
    }
    public MyReview(){
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
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
