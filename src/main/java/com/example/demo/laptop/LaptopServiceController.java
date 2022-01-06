package com.example.demo.laptop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class LaptopServiceController {

    @Autowired
    private LaptopService laptopService;
    @GetMapping(value="/laptops")
    public ResponseEntity<Object> getLaptops (){
        System.out.println("inside getlaptops");
        log.info("getlaptops");
        return new ResponseEntity<>(laptopService.getLaptop(), HttpStatus.OK);
    }
    @GetMapping(value="/laptops/{id}")
    public ResponseEntity<Object> getLaptopById(@PathVariable("id") String var){
        System.out.println("inside laptopsbyid");
        return new ResponseEntity<>(laptopService.getLaptopById(var),HttpStatus.OK);
    }
    @PostMapping(value="/laptops")
    public ResponseEntity<Object> createLaptop(@RequestBody Laptop laptop){
        laptopService.createLaptop(laptop);
        System.out.println("inside createlaptop");
        return new ResponseEntity<>("laptop is  created successfully",HttpStatus.CREATED);
    }
    @PutMapping(value="/laptops/{id}")
    public ResponseEntity<Object> updateLaptop(@PathVariable("id") String id,@RequestBody Laptop laptop){
        laptopService.updateLaptop(id,laptop);
        System.out.println("inside updatelaptop");
        return new ResponseEntity<>("laptop is updated successfully",HttpStatus.OK);
    }
    @DeleteMapping(value="/laptops/{id}")
    public ResponseEntity<Object> deleteLaptop(@PathVariable("id") String id){
        laptopService.deleteLaptop(id);
        System.out.println("inside deletelaptop");
        return new ResponseEntity<>("laptop  is deleted successfully",HttpStatus.OK);
    }
}
