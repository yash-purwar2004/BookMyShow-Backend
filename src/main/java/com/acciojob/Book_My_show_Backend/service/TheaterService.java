package com.acciojob.Book_My_show_Backend.service;

import com.acciojob.Book_My_show_Backend.Enums.SeatType;
import com.acciojob.Book_My_show_Backend.Repository.TheaterRepository;
import com.acciojob.Book_My_show_Backend.Repository.TheaterSeatsRepository;
import com.acciojob.Book_My_show_Backend.Requests.AddTheaterRequest;
import com.acciojob.Book_My_show_Backend.Requests.AddTheaterSeatsRequest;
import com.acciojob.Book_My_show_Backend.model.Theater;
import com.acciojob.Book_My_show_Backend.model.TheaterSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatsRepository theaterSeatsRepository;
    public String addTheater(AddTheaterRequest theaterRequest){
        Theater theater = new Theater();
        theater.setNoOfScreens(theaterRequest.getNoOfScreens());
        theater.setName(theaterRequest.getName());
        theater.setAddress(theaterRequest.getAddress());

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the DB with theaterId "+theater.getTheaterId();
    }

    public String associateSeats(AddTheaterSeatsRequest theaterSeatsRequest){

        int theaterId = theaterSeatsRequest.getTheaterId();
        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();
        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        Theater theater = theaterRepository.findById(theaterId).get();

        //assuming we only have 5 columns in our theater

        //for classic seats:
        int noOfRowsOfClassicSeats = noOfClassicSeats/5;
        int noOfSeatsInLastRowClassic = noOfClassicSeats%5;
        int row;
        for(row=1; row<=noOfRowsOfClassicSeats; row++){
            for(int j=0; j<5; j++){
                char ch = (char)('A' + j);

                String seatNo = "" + row + ch;

                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType(SeatType.CLASSIC);
                theaterSeat.setTheater(theater);

                theaterSeatList.add(theaterSeat);
            }
        }

        //for last row:
        for(int j=0; j<noOfSeatsInLastRowClassic; j++){
            char ch = (char)('A' + j);

            String seatNo = "" + row + ch;

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeat.setTheater(theater);

            theaterSeatList.add(theaterSeat);
        }

        //for premium seats:
        int noOfRowsOfPremiumSeats = noOfClassicSeats/5;
        int noOfSeatsInLastRowPremium = noOfPremiumSeats%5;
        int currentRow = row;
        if(noOfSeatsInLastRowClassic>0){
            currentRow++;
        }
        for(row = currentRow; row<=noOfRowsOfPremiumSeats+currentRow-1; row++){
            for(int j=0; j<5; j++){
                char ch = (char)('A' + j);

                String seatNo = "" + row + ch;

                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType(SeatType.PREMIUM);
                theaterSeat.setTheater(theater);

                theaterSeatList.add(theaterSeat);
            }
        }

        //for last row:
        for(int j=0; j<noOfSeatsInLastRowPremium; j++){
            char ch = (char)('A' + j);

            String seatNo = "" + row + ch;

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setTheater(theater);

            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);

        theaterSeatsRepository.saveAll(theaterSeatList);
        return "The theater seats have been associated";
    }
}
