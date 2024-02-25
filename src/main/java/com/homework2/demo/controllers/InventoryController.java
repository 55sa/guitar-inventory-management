package com.homework2.demo.controllers;

import com.homework2.demo.model.Builder;
import com.homework2.demo.model.Guitar;
import com.homework2.demo.model.Type;
import com.homework2.demo.model.Wood;
import com.homework2.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
public class InventoryController {
    @Autowired
    InventoryRepository IN;
@GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = false) String serialNumber, @RequestParam(required = false, defaultValue = "0.0") double price,
                               @RequestParam(required = false) Builder builder,
                               @RequestParam(required = false)  String model, @RequestParam(required = false) Type type,
                               @RequestParam(required = false) Wood backWood, @RequestParam(required = false) Wood topWoop){
    Guitar searchCriteria = new Guitar(serialNumber, price, builder, model, type, backWood, topWoop);
return IN.search(searchCriteria);

}

@PostMapping("/add")
    public Boolean add( @RequestBody Guitar guitar){
    if(guitar!=null) {

        return IN.addGuitar(guitar);
    }
    return false;
}

@GetMapping("/find/{serialNumber}")
    public Guitar find(@PathVariable String serialNumber){
    return IN.getGuitar(serialNumber);
}


}
