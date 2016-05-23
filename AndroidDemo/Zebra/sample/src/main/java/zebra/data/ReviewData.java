package zebra.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by multimedia on 2016-05-18.
 */
public class ReviewData implements Parcelable {
    public String id;
    public String reviewText;
    public double starPoint;

    @Override
    public int describeContents() {
        return 0;
    }

    public ReviewData(){
    }

    public ReviewData(Parcel in){
        id = in.readString();
        reviewText = in.readString();
        starPoint = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(reviewText);
        dest.writeDouble(starPoint);
    }

    public static final Parcelable.Creator<ReviewData> CREATOR
            = new Parcelable.Creator<ReviewData>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public ReviewData createFromParcel(Parcel in) {
            return new ReviewData(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public ReviewData[] newArray(int size) {
            return new ReviewData[size];
        }
    };
}