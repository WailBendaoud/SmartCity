package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.PointFidelite;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointdeFideliteRepository extends JpaRepository<PointFidelite,Long> {
}
