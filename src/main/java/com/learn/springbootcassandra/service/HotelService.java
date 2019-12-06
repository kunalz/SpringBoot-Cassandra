package com.learn.springbootcassandra.service;

import java.util.List;
import java.util.UUID;

import com.learn.springbootcassandra.model.Hotel;
import com.learn.springbootcassandra.model.HotelByLetter;

public interface HotelService {

    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    Hotel findOne(UUID uuid);
    void delete(UUID uuid);

    List<HotelByLetter> findHotelsStartingWith(String letter);
    List<Hotel> findHotelsInState(String state);

}
