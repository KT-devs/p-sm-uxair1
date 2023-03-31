package ru.uxair.flight.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.entity.dto.TicketDto;
import ru.uxair.flight.repository.TicketRepository;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.mapper.TicketMapper;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Transactional
    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public void updateTicket(TicketDto updatedTicket) {
        ticketRepository.saveAndFlush(ticketMapper.convertToTicket(updatedTicket));
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
