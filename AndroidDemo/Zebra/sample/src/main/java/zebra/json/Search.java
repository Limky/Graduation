package zebra.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import zebra.data.ProductData;

/**
 * Created by multimedia on 2016-05-21.
 */
public class Search implements Parcelable {
    public List<ProductData> productInfo;

    @Override
    public int describeContents() {
        return 0;
    }
    public Search(){

    }

    public Search(Parcel in){
        productInfo = new ArrayList<ProductData>();
        in.readList(productInfo, getClass().getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(productInfo);
    }

    public static final Parcelable.Creator<Search> CREATOR
            = new Parcelable.Creator<Search>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Search createFromParcel(Parcel in) {
            return new Search(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Search[] newArray(int size) {
            return new Search[size];
        }
    };
}
