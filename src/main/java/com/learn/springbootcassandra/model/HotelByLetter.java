package com.learn.springbootcassandra.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Entity
@Table(name="hotel_by_letter")
public class HotelByLetter {

	@PrimaryKeyColumn()
	HotelByLetterKey hotelByLeterKey;

	public HotelByLetter(Hotel hotel) {
		HotelByLetterKey hotelByLetterKey = new HotelByLetterKey();
		hotelByLetterKey.setFirstLetter(hotel.getName().substring(0, 1));
		hotelByLetterKey.setHotelId(hotel.getId());
		hotelByLetterKey.setName(hotel.getName());
		this.setHotelByLetterKey(hotelByLetterKey);
		this.setState(hotel.getState());
		this.setAddress(hotel.getAddress());
		this.setZip(hotel.getZip());
	}

	public HotelByLetterKey getHottelLeterKey() {
		return hotelByLeterKey;
	}

	public void setHotelByLetterKey(HotelByLetterKey hottelLeterKey) {
		this.hotelByLeterKey = hottelLeterKey;
	}

	private String address;

	private String state;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	private String zip;

}
