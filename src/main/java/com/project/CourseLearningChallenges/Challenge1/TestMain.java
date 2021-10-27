package com.project.CourseLearningChallenges.Challenge1;

public class TestMain {

    public static void main(String[] args) throws Exception {

        CustomLinkedList<String> list1 = new CustomLinkedList<>("A", "B", "C", "D");
        list1.append("E", "F", "G", "H");
        System.out.println(list1.getMiddleElement());

        CustomLinkedList<Integer> list2 = new CustomLinkedList<>();
        list2.append(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list2.getMiddleElement());

        CustomLinkedList<Long> list3 = new CustomLinkedList<>(1l, 2l, 3l, 4l, 5l);
        System.out.println(list3.getMiddleElement());

        System.out.println();

        for(String s : list1)
            System.out.println(s);

        System.out.println(list2);

        list3.forEach((n) -> System.out.println(n));
    }
}
