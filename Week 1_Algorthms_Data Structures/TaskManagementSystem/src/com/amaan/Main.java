package com.amaan;

public class Main {

    public static void main(String[] args) {
        Task task1 = new Task(1, "Create website", "no");
        Task task2 = new Task(2, "Complete Assignment", "yes");
        Task task3 = new Task(3, "Complete design", "no");
        TaskLinkedList taskLinkedList = new TaskLinkedList();

        taskLinkedList.addTask(task1);
        taskLinkedList.addTask(task2);
        taskLinkedList.addTask(task3);

        System.out.println("Tasks");
        taskLinkedList.traverseTasks();

        System.out.println(taskLinkedList.searchTaskById(2));

        taskLinkedList.deleteTaskById(2);

        System.out.println("Tasks");
        taskLinkedList.traverseTasks();

    }
}
