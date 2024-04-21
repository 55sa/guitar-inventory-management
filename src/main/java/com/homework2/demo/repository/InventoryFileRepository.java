package com.homework2.demo.repository;

import com.homework2.demo.model.Builder;
import com.homework2.demo.model.Guitar;
import com.homework2.demo.model.Type;
import com.homework2.demo.model.Wood;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class InventoryFileRepository {
    private static final String DATABASE_FILE = "guitars_database.txt";

    public Boolean addGuitar(Guitar guitar) {
        try (FileWriter fw = new FileWriter(DATABASE_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(guitarToString(guitar));
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public Guitar getGuitar(String serialNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_FILE))) {
            return br.lines()
                    .map(this::stringToGuitar).filter(Objects::nonNull)
                    .filter(guitar -> guitar.getSerialNumber().equals(serialNumber))
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }

    public List<Guitar> search(Guitar searchCriteria) {
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_FILE))) {
            return br.lines()
                    .map(this::stringToGuitar)
                    .filter(guitar -> matchesCriteria(guitar, searchCriteria))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // Handle exception
            return new ArrayList<>();
        }
    }

    private boolean matchesCriteria(Guitar guitar, Guitar criteria) {
        if (criteria.getSerialNumber() != null && !criteria.getSerialNumber().isEmpty()
                && !guitar.getSerialNumber().contains(criteria.getSerialNumber())) {
            return false;
        }
        if (criteria.getPrice() != 0 && !criteria.getPrice().equals(guitar.getPrice())) {
            return false;
        }
        if (criteria.getBuilder() != null && !criteria.getBuilder().toString().isEmpty()
                && !guitar.getBuilder().toString().contains(criteria.getBuilder().toString())) {
            return false;
        }
        if (criteria.getModel() != null && !criteria.getModel().isEmpty()
                && !guitar.getModel().contains(criteria.getModel())) {
            return false;
        }
        if (criteria.getType() != null && !criteria.getType().toString().isEmpty()
                && !guitar.getType().toString().contains(criteria.getType().toString())) {
            return false;
        }
        if (criteria.getBackWood() != null && !criteria.getBackWood().toString().isEmpty()
                && !guitar.getBackWood().toString().contains(criteria.getBackWood().toString())) {
            return false;
        }
        if (criteria.getTopWoop()!= null && !criteria.getTopWoop().toString().isEmpty()
                && !guitar.getTopWoop().toString().contains(criteria.getTopWoop().toString())) {
            return false;
        }

        return true;
    }

    private String guitarToString(Guitar guitar) {
        return String.join(",",
                guitar.getSerialNumber(),
                String.valueOf(guitar.getPrice()),
                guitar.getBuilder().toString(),
                guitar.getModel(),
                guitar.getType().toString(),
                guitar.getBackWood().toString(),
                guitar.getTopWoop().toString());
    }

    private Guitar stringToGuitar(String str) {
        String[] parts = str.split(",");
        if (parts.length < 7) {
            return null;
        }

        String serialNumber = parts[0].trim();
        double price = Double.parseDouble(parts[1].trim());

        Builder
            builder = Builder.valueOf(parts[2].trim().toUpperCase());


        String model = parts[3].trim();

        Type
            type = Type.valueOf(parts[4].trim().toUpperCase());

        Wood
            backWood = Wood.valueOf(parts[5].trim().toUpperCase());




        Wood    topWood = Wood.valueOf(parts[6].trim().replace(" ", "_").toUpperCase());


        return new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
    }





}
