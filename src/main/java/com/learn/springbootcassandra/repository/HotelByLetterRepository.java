package com.learn.springbootcassandra.repository;

import java.util.List;

import com.learn.springbootcassandra.model.HotelByLetter;
import com.learn.springbootcassandra.model.HotelByLetterKey;

public interface HotelByLetterRepository {


    List<HotelByLetter> findByFirstLetter(String letter);
    HotelByLetter save(HotelByLetter hotelByLetter);
    void delete(HotelByLetterKey hotelByLetterKey);

}
