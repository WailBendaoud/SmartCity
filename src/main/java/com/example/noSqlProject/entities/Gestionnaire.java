package com.example.noSqlProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.util.Date;

@TypeAlias("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire extends User{
    private Date dateEmboche;
}
