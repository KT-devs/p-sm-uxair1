package ru.uxair.flight.service;


import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.entity.dto.TicketDto;

public interface TicketService {
    void saveTicket(Ticket ticket);
    void updateTicket(TicketDto updatedTicket);
    Ticket getTicketById(Long id);
    void deleteTicketById(Long id);
}
