package com.kloster.repository.postgres;

import com.kloster.entity.postgres.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity, Long> {
    MyEntity findByNome(String nome);
}
