package com.example.demo.laptop;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LaptopService {
    Map<String,Laptop> laptopMap=new HashMap<>();
    public Collection<Laptop> getLaptop(){
        return laptopMap.values();
    }
    public Laptop getLaptopById(String id){
        return laptopMap.get(id);
    }
    public void createLaptop(Laptop laptop){
        laptopMap.put(laptop.getId(), laptop);
    }
    public void updateLaptop(String id, Laptop laptop ){
        laptopMap.remove(id);
        laptopMap.put(laptop.getId(), laptop);
    }
    public void deleteLaptop(String id){
        laptopMap.remove(id);
    }
}
