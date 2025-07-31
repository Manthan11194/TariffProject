package com.example.tariffengineservice.repository;


import com.example.tariffengineservice.entity.TariffRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TariffRuleRepository extends JpaRepository<TariffRule, Long> {

    List<TariffRule> findByLevelAndEntityIdAndCountry(String level, String entityId, String country);

    List<TariffRule> findByLevelAndEntityIdInAndCountry(String level, List<String> entityIds, String country);
}
