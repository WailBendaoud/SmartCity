package com.example.noSqlProject.repositories.mysql;

import com.example.noSqlProject.entities.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
