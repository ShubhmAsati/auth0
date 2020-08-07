package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.GeoLocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaGeoLocationRepository extends JpaRepository<GeoLocationEntity, UUID> {

    @Query(value = "SELECT OBJECTS FROM GEO_LOCATION WHERE TYPE= :type AND " +
            "LATITUDE BETWEEN (:latMin,:longMin) AND LONGITUDE BETWEEN (:longMin,:longMax) " +
            "AND (LATITUDE!= :latitude AND LONGITUDE!= :longitude)" +
            "ORDER BY calculate_distance(LATITUDE,LONGITUDE,:latitude,:longitude)"
             , nativeQuery = true)
      Page<UUID> getObjectsByCoordinatesAndTypePerPage
            (@Param("lat") Double latitude, @Param("lng") Double longitude, @Param("latMax") Double latMax,
             @Param("longMax") Double longMax, @Param("latMin") Double latMin, @Param("longMin") Double longMin,
             @Param("type") String type, Pageable pageable);


}


