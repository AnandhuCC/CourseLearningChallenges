package com.project.CourseLearningChallenges.Challenge2;

import java.util.*;

public class FCFSQueue<T extends GuestInterface> implements CustomQueue<T> {

    private int N, prioritySize, size;
    private ArrayDeque<T> prioritizedGuests;
    private ArrayDeque<T> guests;

    public FCFSQueue(int N) {
        this.N = N;
        this.prioritySize = 0;
        this.size = 0;
        prioritizedGuests = new ArrayDeque<>();
        guests = new ArrayDeque<>();
    }

    public boolean addGuest(T t) {

        if(t.hasPriority() && prioritySize < N) {
            prioritizedGuests.addLast(t);
            prioritySize++;
            if(size == N)
                guests.removeLast();
            else
                size++;
            return true;
        }
        else if(size < N) {
            size++;
            guests.addLast(t);
            return true;
        }

        return false;
    }

    public Optional<T> pollGuest() {

        if(prioritySize > 0) {
            prioritySize--;
            size--;
            return Optional.of(prioritizedGuests.removeFirst());
        }
        else if(size > 0) {
            size--;
            return Optional.of(guests.removeFirst());
        }

        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int x = 0, y = 0, z = 0;
            private ArrayList<T> pg = new ArrayList<>(prioritizedGuests);
            private ArrayList<T> g = new ArrayList<>(guests);

            @Override
            public boolean hasNext() {
                return y != size;
            }

            @Override
            public T next() {
                if(x < prioritySize) {
                    y++;
                    return pg.get(x++);
                }
                else if(y < size) {
                    y++;
                    return g.get(z++);
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
