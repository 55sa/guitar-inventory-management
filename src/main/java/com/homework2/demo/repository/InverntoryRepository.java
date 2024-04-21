package com.homework2.demo.repository;

import com.homework2.demo.model.Builder;
import com.homework2.demo.model.Guitar;
import com.homework2.demo.model.Type;
import com.homework2.demo.model.Wood;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InverntoryRepository extends CrudRepository<Guitar,String> {

    List<Guitar> findBySerialNumberAndModelAndPriceAndBuilderAndTypeAndBackWoodAndTopWoop(String serialNumber,
                                                                 String model, Double price, Builder builder,
                                                                 Type type, Wood backwood ,Wood topwoop);

}
