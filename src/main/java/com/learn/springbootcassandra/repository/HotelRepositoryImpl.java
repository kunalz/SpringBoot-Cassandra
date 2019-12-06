package com.learn.springbootcassandra.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.learn.springbootcassandra.model.Hotel;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
	CassandraOperations cassandraOperationsTemplate;

	@Autowired
	public HotelRepositoryImpl(CassandraOperations cassandraTemplate) {
		this.cassandraOperationsTemplate = cassandraTemplate;
	}

	@Override
	public Hotel save(Hotel hotel) {
		return cassandraOperationsTemplate.insert(hotel);

	}

	@Override
	public Hotel update(Hotel hotel) {
		return cassandraOperationsTemplate.update(hotel);
	}

	@Override
	public Hotel findOne(UUID hotelId) {

		return cassandraOperationsTemplate.selectOneById(hotelId, Hotel.class);
	}

	@Override
	public void delete(UUID hotelId) {
		cassandraOperationsTemplate.deleteById(hotelId, Hotel.class);
	}

	@Override
	public List<Hotel> findByState(String state) {
		Select select = QueryBuilder.select().from("hotels_by_state");
		select.where(QueryBuilder.eq("state", state));
		return cassandraOperationsTemplate.select(select, Hotel.class);
	}

}
