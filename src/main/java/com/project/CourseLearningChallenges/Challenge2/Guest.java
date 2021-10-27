package com.project.CourseLearningChallenges.Challenge2;

public final class Guest implements GuestInterface {

    private final String name;
    private final boolean hasPriority;

    public Guest(String name, boolean hasPriority) {
        this.name = name;
        this.hasPriority = hasPriority;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean hasPriority() {
        return hasPriority;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, hasPriority ? "Yes" : "No");
    }
}
