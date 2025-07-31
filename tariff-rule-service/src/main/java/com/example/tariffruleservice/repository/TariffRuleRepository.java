package com.example.tariffruleservice.repository;

import com.example.tariffruleservice.entity.TariffRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TariffRuleRepository extends JpaRepository<TariffRule, Long> {
    Optional<TariffRule> findByEntityIdAndCountryAndLevel(String entityId, String country, String level);

}
