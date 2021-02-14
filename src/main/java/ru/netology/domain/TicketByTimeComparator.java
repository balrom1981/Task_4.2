package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        if ((o1.getTime() - o2.getTime()) != 0){
            return o1.getTime() - o2.getTime();
        }
        return o1.getPrice() - o2.getPrice();
    }
}