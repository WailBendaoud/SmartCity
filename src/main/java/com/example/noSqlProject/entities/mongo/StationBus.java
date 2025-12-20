package com.example.noSqlProject.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StationBus {
    //@Id
    //private String id;
    private String nom;
    private String position;
}
