package com.example.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class UserNation {
    @Id
    private int id;
    private String name;
    private int highestAmountEnergy;
    private int highestAmountMineral;
    private int highestAmountFood;
    private int highestAmountAlloy;
    private int highestAmountYaoi;
}
