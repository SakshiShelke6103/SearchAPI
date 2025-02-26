package com.example.search.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.search.model.Hotel;
import java.util.List;


public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findByLocationIgnoreCase(String location);
}
