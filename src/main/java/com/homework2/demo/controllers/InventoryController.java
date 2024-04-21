package com.homework2.demo.controllers;

import com.homework2.demo.model.Builder;
import com.homework2.demo.model.Guitar;
import com.homework2.demo.model.Type;
import com.homework2.demo.model.Wood;
import com.homework2.demo.repository.InventoryFileRepository;
import com.homework2.demo.repository.InverntoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@CrossOrigin
public class InventoryController {
    @Autowired
   InverntoryRepository IN;
@GetMapping("/search")
    public List<Guitar> search(@RequestParam(required = false) String serialNumber, @RequestParam(required = false, defaultValue = "0.0") double price,
                               @RequestParam(required = false) Builder builder,
                               @RequestParam(required = false)  String model, @RequestParam(required = false) Type type,
                               @RequestParam(required = false) Wood backWood, @RequestParam(required = false) Wood topWoop){
    Guitar searchCriteria = new Guitar(serialNumber, price, builder, model, type, backWood, topWoop);
return IN.findBySerialNumberAndModelAndPriceAndBuilderAndTypeAndBackWoodAndTopWoop(serialNumber,model,price,builder,type,backWood,topWoop);

}

@PostMapping("/add")
    public Boolean add( @RequestBody Guitar guitar){
    if(guitar!=null) {

       IN.save(guitar);
       return true;
    }
    return false;
}

@GetMapping("/find/{serialNumber}")
    public Optional<Guitar> find(@PathVariable String serialNumber){
    return IN.findById(serialNumber);
}


}
