package com.acciojob.Book_My_show_Backend.service;

import com.acciojob.Book_My_show_Backend.Repository.MovieRepository;
import com.acciojob.Book_My_show_Backend.Repository.ShowRepository;
import com.acciojob.Book_My_show_Backend.Repository.ShowSeatRepository;
import com.acciojob.Book_My_show_Backend.Repository.TheaterRepository;
import com.acciojob.Book_My_show_Backend.Requests.AddShowRequest;
import com.acciojob.Book_My_show_Backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest showRequest){

        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());
        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();

        //we can add messages for validations:

        Show show = new Show();
        show.setShowDate(showRequest.getShowDate());
        show.setShowTime(showRequest.getShowTime());
        show.setMovie(movie);
        show.setTheater(theater);

        show = showRepository.save(show);

        //Associate the corresponding show seats
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());
            showSeat.setIsBooked(Boolean.FALSE);
            showSeat.setIsFoodAttached(Boolean.FALSE);
            showSeat.setShow(show);

            showSeatList.add(showSeat);
        }

        //setting the bidirectional mapping attribute:
        show.setShowSeatList(showSeatList);
        showSeatRepository.saveAll(showSeatList);

        return "The show has been saved to the db with the showId "+show.getShowId();
    }
}
