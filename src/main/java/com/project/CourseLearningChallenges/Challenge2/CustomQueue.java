package com.project.CourseLearningChallenges.Challenge2;

import java.util.Optional;

public interface CustomQueue<T> extends Iterable<T> {

    boolean addGuest(T t);

    Optional<T> pollGuest();
}
