package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

public class Test13StrictStubbing {

    @InjectMocks
    private BookingService bookingService;
    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Spy
    private BookingDAO bookingDAOMock;
    @Mock
    private MailSender mailSenderMock;
    @Captor
    private ArgumentCaptor<Double> doubleCaptor;

    @Test
    void should_InvokePayment_When_Prepaid() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2021, 01, 01),
                LocalDate.of(2021, 01, 05), 2, true);
        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1");

        //when
        bookingService.makeBooking(bookingRequest);

        //then
        // no exception is thrown
    }

}
