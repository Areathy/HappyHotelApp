package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.* ;


public class Test02DefaultReturnValues {

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

//       Snick pick of some default return values from roomServiceMock
        System.out.println("List Returned: " + roomServiceMock.getAvailableRooms());
        System.out.println("Object Returned: " + roomServiceMock.findAvailableRoomId(null));
        System.out.println("Primitive Returned: " + roomServiceMock.getRoomCount());
    }


        @Test
    void should_getAvailablePlaceCount() {
        //given
        int expected = 0;

        // when
        int actual = bookingService.getAvailablePlaceCount();

        // then
        assertEquals(expected,actual);
    }
}
