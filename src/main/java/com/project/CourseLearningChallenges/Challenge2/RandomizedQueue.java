package com.project.CourseLearningChallenges.Challenge2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

public class RandomizedQueue<T extends GuestInterface> implements CustomQueue<T> {

    private int N, prioritySize, size;
    private ArrayList<T> prioritizedGuests;
    private ArrayList<T> guests;
    private Random random;

    public RandomizedQueue(int N) {
        this.N = N;
        this.prioritySize = 0;
        this.size = 0;
        this.random = new Random();
        prioritizedGuests = new ArrayList<>();
        guests = new ArrayList<>();
    }

    private void randomSwap(ArrayList<T> list) {
        int size = list.size();
        int rand = random.nextInt(size);
        T t = list.get(rand);
        list.set(rand, list.get(size - 1));
        list.set(size - 1, t);
    }

    @Override
    public boolean addGuest(T t) {

        if(t.hasPriority() && prioritySize < N) {
            prioritizedGuests.add(t);
            prioritySize++;
            randomSwap(prioritizedGuests);
            if(size == N)
                guests.remove(guests.size() - 1);
            else
                size++;
            return true;
        }
        else if(size < N) {
            size++;
            guests.add(t);
            return true;
        }

        return false;
    }

    @Override
    public Optional<T> pollGuest() {

        if(prioritySize > 0) {
            prioritySize--;
            size--;
            return Optional.of(prioritizedGuests.remove(prioritySize));
        }
        else if(size > 0) {
            size--;
            return Optional.of(guests.remove(guests.size() - 1));
        }

        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {

            private int x = 0, y = 0, z = 0;

            @Override
            public boolean hasNext() {
                return y != size;
            }

            @Override
            public T next() {

                if(x < prioritySize) {
                    y++;
                    return prioritizedGuests.get(x++);
                }
                else if(y < size) {
                    y++;
                    return guests.get(z++);
                }
                return null;
            }
        };
        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for(T t : this)
            stringBuilder.append(t + ", ");
        stringBuilder.setLength(Math.max(1, stringBuilder.length() - 2));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
