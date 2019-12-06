package com.learn.springbootcassandra.model;

import java.util.UUID;

import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;

@PrimaryKeyClass
public class HotelByLetterKey {

	@PrimaryKeyJoinColumn(name = "first_letter")
	private String firstLetter;
	@PrimaryKeyJoinColumn(name = "hotel_name")
	private String name;
	@PrimaryKeyJoinColumn(name = "hotel_id")
	private UUID hotelId;

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getHotelId() {
		return hotelId;
	}

	public void setHotelId(UUID hotelId) {
		this.hotelId = hotelId;
	}

}
