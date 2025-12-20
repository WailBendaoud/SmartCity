package com.example.noSqlProject.services.api;

import com.example.noSqlProject.entities.mysql.Gestionnaire;
import com.example.noSqlProject.services.GenericService;

public interface GestionnaireService extends GenericService<Gestionnaire,Long> {
    Gestionnaire addParking(Long id,String idParking);
}
