package com.learn.springbootcassandra.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.learn.springbootcassandra.model.HotelByLetter;
import com.learn.springbootcassandra.model.HotelByLetterKey;

@Repository
public class HotelByLetterRepositoryImpl implements HotelByLetterRepository{
	
	CassandraOperations cassandraOperationsTemplate;

	@Autowired
	public HotelByLetterRepositoryImpl(CassandraOperations cassandraTemplate) {
		this.cassandraOperationsTemplate = cassandraTemplate;
	}

	@Override
	public List<HotelByLetter> findByFirstLetter(String letter) {
		Select select = QueryBuilder.select().from("hotel_by_letter");
		select.where(QueryBuilder.eq("first_letter", letter));
		return cassandraOperationsTemplate.select(select, HotelByLetter.class);
	}

	@Override
	public HotelByLetter save(HotelByLetter hotelByLetter) {
		return cassandraOperationsTemplate.insert(hotelByLetter);
	}

	@Override
	public void delete(HotelByLetterKey hotelByLetterKey) {
		cassandraOperationsTemplate.delete(hotelByLetterKey);
	}

}
