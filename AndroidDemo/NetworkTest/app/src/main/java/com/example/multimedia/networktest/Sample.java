package com.example.multimedia.networktest;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by multimedia on 2016-05-19.
 */
public class Sample {
    List<Review> reviews;
    ProductInfo productInfo;

    public Sample(){
        productInfo = new ProductInfo();
        reviews = new List<Review>() {
            @Override
            public void add(int location, Review object) {

            }

            @Override
            public boolean add(Review object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends Review> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Review> collection) {
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
            public Review get(int location) {
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
            public Iterator<Review> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<Review> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Review> listIterator(int location) {
                return null;
            }

            @Override
            public Review remove(int location) {
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
            public Review set(int location, Review object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<Review> subList(int start, int end) {
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
