package zebra.json;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import zebra.data.ProductData;

/**
 * Created by multimedia on 2016-05-21.
 */
public class Search {
    public List<ProductData> productInfo;
    public Search(){
        productInfo = new List<ProductData>() {
            @Override
            public void add(int location, ProductData object) {

            }

            @Override
            public boolean add(ProductData object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends ProductData> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ProductData> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public ProductData get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<ProductData> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<ProductData> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<ProductData> listIterator(int location) {
                return null;
            }

            @Override
            public ProductData remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public ProductData set(int location, ProductData object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<ProductData> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
    }
}
