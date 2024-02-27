package com.homework2.demo.repository;

import com.homework2.demo.model.Guitar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.homework2.demo.model.Builder.FENDER;
import static com.homework2.demo.model.Type.ACOUSTIC;
import static com.homework2.demo.model.Wood.ALDER;
import static com.homework2.demo.model.Wood.BRAZILIAN_ROSEWOOD;
import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    InventoryRepository IN=new InventoryRepository();

    @Test
    void addGuitar() {
        assertEquals(true,IN.addGuitar( new Guitar("acd",24,FENDER,"M",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER)));
        assertEquals(true,IN.addGuitar(new Guitar("atd",25,FENDER,"M",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER)));
        assertEquals(true,IN.addGuitar(new Guitar("agd",26,FENDER,"P",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER)));
        assertEquals(true,IN.addGuitar(new Guitar("akd",27,FENDER,"O",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER)));
    }

    @Test
    void getGuitar() {
        Guitar guitar1=new Guitar("acd",24,FENDER,"M",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER);
        Guitar guitar2=new Guitar("atd",25,FENDER,"M",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER);
        Guitar guitar3=new Guitar("agd",26,FENDER,"P",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER);
        Guitar guitar4=new Guitar("akd",27,FENDER,"O",ACOUSTIC,BRAZILIAN_ROSEWOOD,ALDER);

        assertEquals(guitar1,IN.getGuitar("acd"));
        assertEquals(guitar2,IN.getGuitar("atd"));
        assertEquals(guitar3,IN.getGuitar("agd"));
        assertEquals(guitar4,IN.getGuitar("akd"));
    }

    @Test
    void search() {


    }
}