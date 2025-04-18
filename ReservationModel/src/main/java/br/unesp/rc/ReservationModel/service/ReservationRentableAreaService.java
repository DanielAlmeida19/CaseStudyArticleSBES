package br.unesp.rc.ReservationModel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.rc.ReservationModel.model.RentableArea;
import br.unesp.rc.ReservationModel.repository.RentableAreaRepository;


@Service
public class ReservationRentableAreaService {

    @Autowired
    RentableAreaRepository rentableAreaRepository;

    public List<RentableArea> findAll() {
        List<RentableArea> rentableAreas = rentableAreaRepository.findAll();
        return rentableAreas;
    }

    public RentableArea findById(Long id) {
        Optional<RentableArea> rentableArea = rentableAreaRepository.findById(id);
        if (rentableArea.isEmpty()) {
            throw new RuntimeException("RentableArea not found");
        }
        return rentableArea.get();
    }
    
    public RentableArea save(RentableArea rentableArea) {
        RentableArea newRentableArea = rentableAreaRepository.save(rentableArea);
        return newRentableArea;
    }

    public void delete(Long id) {
        rentableAreaRepository.deleteById(id);
    }

    public RentableArea update(RentableArea rentableArea) {
        RentableArea oldRentableArea = findById(rentableArea.getId());
        updateRentableArea(oldRentableArea, rentableArea);
        RentableArea updatedRentableArea = rentableAreaRepository.save(oldRentableArea);
        return updatedRentableArea;
    }

    public void updateRentableArea(RentableArea oldRentableArea, RentableArea newRentableArea) {
        if (newRentableArea.getName() != null) {
            oldRentableArea.setName(newRentableArea.getName());
        }

        if (newRentableArea.getSize() != 0) {
            oldRentableArea.setSize(newRentableArea.getSize());
        }

        if (newRentableArea.getCapacity() != 0) {
            oldRentableArea.setCapacity(newRentableArea.getCapacity());
        }

        if (newRentableArea.getValue() != 0) {
            oldRentableArea.setValue(newRentableArea.getValue());
        }
    }
}
