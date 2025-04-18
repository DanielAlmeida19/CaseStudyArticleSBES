package br.unesp.rc.ReservationModel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unesp.rc.ReservationModel.model.Resident;


@Repository("reservationResidentRepository")
public interface ResidentRepository extends JpaRepository<Resident, String> {
    
}
