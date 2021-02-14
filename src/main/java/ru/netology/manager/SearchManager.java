package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeComparator;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class SearchManager {
    private TicketRepository repository;
    TicketByTimeComparator comparator = new TicketByTimeComparator();
    public SearchManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] searchBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equalsIgnoreCase(from) & ticket.getTo().equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }

}


