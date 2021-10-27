package com.project.CourseLearningChallenges.Challenge2;

import java.util.Random;

public class TestMain {

    public static void main(String[] args) {

        CustomQueue<Guest> saturday = new FCFSQueue<>(20);
        CustomQueue<Guest> sunday = new FCFSQueue<>(20);

        CustomQueue<Guest> monday = new RandomizedQueue<>(20);
        CustomQueue<Guest> tuesday = new RandomizedQueue<>(20);
        CustomQueue<Guest> wednesday = new RandomizedQueue<>(20);
        CustomQueue<Guest> thursday = new RandomizedQueue<>(20);
        CustomQueue<Guest> friday = new RandomizedQueue<>(20);


        CustomQueue<Guest>[] queues = new CustomQueue[]{sunday, monday, tuesday, wednesday, thursday, friday, saturday};
        String[] names = new String[]{"Joe", "Frank", "Josh", "Nancy", "Ned", "Dana", "Mulder", "Scully", "Fox",
                                      "Beth", "Bess", "Peter", "Jack", "Pam", "Janet", "Barbara", "George"};
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        Random random = new Random();

        System.out.println("Order of booking : ");

        int i = 0;
        for(CustomQueue<Guest> queue : queues) {
            System.out.print(days[i++] + " : ");
            for (int j = 0; j < 40; j++) {
                int rand = random.nextInt(names.length);
                Guest guest = new Guest(names[rand], Math.random() < 0.3 ? true : false);
                System.out.print(guest + ", ");
                queue.addGuest(guest);
            }
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("Order of ticket allotment : ");

        i = 0;
        for(CustomQueue<Guest> queue : queues)
            System.out.println(days[i++] + " : " + queue);
    }
}
