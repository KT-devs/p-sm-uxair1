package ru.uxair.flight.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Ticket;
import ru.uxair.flight.entity.dto.TicketDto;


@Component
@AllArgsConstructor
public class TicketMapper {
    private final ModelMapper modelMapper;

    public Ticket convertToTicket(TicketDto ticketDto) {
        return modelMapper.map(ticketDto, Ticket.class);
    }

    public TicketDto convertToTicketDto(Ticket ticket) {
        return modelMapper.map(ticket, TicketDto.class);
    }
}
