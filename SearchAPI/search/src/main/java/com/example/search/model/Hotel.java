package com.example.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels") 
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
  

    public Hotel() {}

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

   

	
}
