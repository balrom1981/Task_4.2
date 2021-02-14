package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeComparator;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SearchManagerTest {
    TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 4000, "DME", "LED", 90);
    private Ticket second = new Ticket(2, 2000, "SVO", "LED", 95);
    private Ticket third = new Ticket(3, 3000, "LED", "AER", 150);
    private Ticket fourth = new Ticket(4, 4000, "DME", "AER", 120);
    private Ticket fifth = new Ticket(5, 5000, "AER", "SVO", 130);
    private Ticket sixth = new Ticket(6, 1000, "DME", "LED", 90);
    private Ticket seventh = new Ticket(7, 7000, "DME", "LED", 80);

    @Test
    public void shouldSearchTwoCoincidenceSort() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(seventh);
        SearchManager manager = new SearchManager(repository);
        TicketByTimeComparator comparator = new TicketByTimeComparator();

        Ticket[] actual = manager.searchBy("DME", "LED", comparator);
        Ticket[] expected = new Ticket[]{seventh, first};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchTreeCoincidenceSort() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        SearchManager manager = new SearchManager(repository);
        TicketByTimeComparator comparator = new TicketByTimeComparator();

        Ticket[] actual = manager.searchBy("DME", "LED", comparator);
        Ticket[] expected = new Ticket[]{seventh, sixth, first};

        assertArrayEquals(actual, expected);


    }

}