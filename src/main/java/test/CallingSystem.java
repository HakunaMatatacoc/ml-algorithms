package test;

import java.util.LinkedList;
import java.util.Queue;

public class CallingSystem {

    private Queue<String> queue = new LinkedList<>();
    private int ticketNumber = 1;

    public synchronized void takeTicket(String name) {
        String ticket = String.format("Ticket %d - %s", ticketNumber++, name);
        queue.add(ticket);
        System.out.println(ticket + " is taken.");
        notifyAll();
    }

    public synchronized void callNext() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String ticket = queue.poll();
        System.out.println(ticket + " is called.");
    }

    public static void main(String[] args) {
        CallingSystem hospital = new CallingSystem();

        Runnable takeTicketTask = () -> {
            for (int i = 1; i <= 10; i++) {
                String name = "Patient " + i;
                hospital.takeTicket(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable callNextTask = () -> {
            for (int i = 1; i <= 10; i++) {
                hospital.callNext();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread takeTicketThread = new Thread(takeTicketTask);
        Thread callNextThread = new Thread(callNextTask);

        takeTicketThread.start();
        callNextThread.start();
    }
}