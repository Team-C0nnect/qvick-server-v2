package com.project.qvick.domain.wifi.domain.repository;

import com.project.qvick.domain.wifi.domain.WifiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WifiRepository extends JpaRepository<WifiEntity,Long> {

    Optional<WifiEntity> findBySsid (String ssid);

}
