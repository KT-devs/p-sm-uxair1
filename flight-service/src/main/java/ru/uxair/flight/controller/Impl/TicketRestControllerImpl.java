package ru.uxair.flight.controller.Impl;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.flight.controller.TicketRestController;
import ru.uxair.flight.entity.dto.TicketDto;
import ru.uxair.flight.service.TicketService;
import ru.uxair.flight.util.mapper.TicketMapper;

@RestController
@AllArgsConstructor
public class TicketRestControllerImpl implements TicketRestController {
    private TicketService ticketService;
    private TicketMapper ticketMapper;

    @Override
    public ResponseEntity<HttpStatus> saveNewTicket(@NonNull TicketDto ticketDto) {
        ticketService.saveTicket(ticketMapper.convertToTicket(ticketDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateTicketById(@NonNull Long id) {
        ticketService.updateTicket(ticketMapper.convertToTicketDto(ticketService.getTicketById(id)));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TicketDto> getTicketById(@NonNull Long id) {
        return ResponseEntity.ok(ticketMapper.convertToTicketDto(ticketService.getTicketById(id)));
    }

    @Override
    public ResponseEntity<HttpStatus> deleteTicketById(@NonNull Long id) {
        ticketService.deleteTicketById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
