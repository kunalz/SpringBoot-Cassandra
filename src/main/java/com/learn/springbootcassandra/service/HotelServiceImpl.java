package com.learn.springbootcassandra.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springbootcassandra.model.Hotel;
import com.learn.springbootcassandra.model.HotelByLetter;
import com.learn.springbootcassandra.repository.HotelByLetterRepository;
import com.learn.springbootcassandra.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	HotelRepository hotelRepository;
	HotelByLetterRepository hotelByLetterRepository;

	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepository, HotelByLetterRepository hotelByLetterRepository) {
		this.hotelRepository = hotelRepository;
		this.hotelByLetterRepository = hotelByLetterRepository;
	}

	@Override
	public Hotel save(Hotel hotel) {
		if (hotel.getId() == null) {
			hotel.setId(UUID.randomUUID());
		}
		Hotel psersistedHotel = hotelRepository.save(hotel);
		hotelByLetterRepository.save(new HotelByLetter(hotel));

		return psersistedHotel;
	}

	@Override
	public Hotel update(Hotel hotel) {
		Hotel existtingHotel = hotelRepository.findOne(hotel.getId());
		if (existtingHotel != null) {
			hotelByLetterRepository.delete(new HotelByLetter(hotel).getHottelLeterKey());
			existtingHotel = hotelRepository.update(hotel);
		}
		return existtingHotel;
	}

	@Override
	public Hotel findOne(UUID uuid) {
		return this.hotelRepository.findOne(uuid);
	}

	@Override
	public void delete(UUID uuid) {
		Hotel hotel = this.hotelRepository.findOne(uuid);
		if (hotel != null) {
			this.hotelRepository.delete(uuid);
			this.hotelByLetterRepository.delete(new HotelByLetter(hotel).getHottelLeterKey());
		}
	}

	@Override
	public List<HotelByLetter> findHotelsStartingWith(String letter) {
		return this.hotelByLetterRepository.findByFirstLetter(letter);
	}

	@Override
	public List<Hotel> findHotelsInState(String state) {
		return this.hotelRepository.findByState(state);
	}

}
