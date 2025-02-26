package com.example.search.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.search.model.Hotel;
import com.example.search.repository.HotelRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
@Tag(name = "Hotel Controller", description = "APIs for managing hotels")
@CrossOrigin(origins = "*") // Allow API calls from all domains
public class controller {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/search")
    @Operation(summary = "Search hotels by location", description = "Finds hotels based on the provided location and displays only name and description")
    public List<HotelResponse> searchHotelsByLocation(@RequestParam String location) {
        List<Hotel> hotels = hotelRepository.findByLocationIgnoreCase(location);
        if (hotels.isEmpty()) {
            throw new RuntimeException("No hotels found in location: " + location);
        }
      
        return hotels.stream()
                .map(hotel -> new HotelResponse(hotel.getName() ))
                .collect(Collectors.toList());
    }

   
    public static class HotelResponse {
        private String name;
       
        public HotelResponse(String name ) {
            this.name = name;
           
        }

       

		public String getName() { return name; }



		


		



		


		
       
    }
}
