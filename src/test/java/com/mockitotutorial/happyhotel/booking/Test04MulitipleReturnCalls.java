package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Test04MulitipleReturnCalls {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setUp() {
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
    }

    @Test
    void  should_CountAvailablePlaces_When_CalledMultipleTimes() {
        //given
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(Collections.singletonList(new Room("Room 1", 5)))
                .thenReturn(Collections.singletonList(new Room("Room 2", 87)))
                .thenReturn(Collections.emptyList());
        int expectedFirstCall = 9;
        int expectedSecondCall = 87;
        int expectedThirdCall = 0;

        //when
        int actualFirstCall = bookingService.getAvailablePlaceCount();
        int actualSecondCall = bookingService.getAvailablePlaceCount();
        int actualThirdCall = bookingService.getAvailablePlaceCount();

        //then
        assertAll(
            () -> assertEquals(expectedFirstCall, actualFirstCall),
            () -> assertEquals(expectedSecondCall, actualSecondCall),
            () -> assertEquals(expectedThirdCall, actualThirdCall)
        );

    }
}
