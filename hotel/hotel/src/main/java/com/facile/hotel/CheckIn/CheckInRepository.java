/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.facile.hotel.checkin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {

    Optional<CheckIn> findByHabitacionIdAndFechaCheckOutIsNull(Long habitacionId);
}
