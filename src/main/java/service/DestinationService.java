package service;

import entity.Destination;
import repository.DestinationRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DestinationService {


    public static final DestinationRepository destinationRepository = new DestinationRepository();

    public Destination CreateDestination(int destination_id, String destinationName) {
        return destinationRepository.CreateDestination(destination_id, destinationName);
    }

    public List getDestinations() {
        return destinationRepository.getDestinations();
    }

    public Destination getDestinationById(int destinationId) {
        return destinationRepository.getDestinationById(destinationId);
    }

    public void deleteDestinationById(int destinationId) {
        destinationRepository.deleteDestinationById(destinationId);
    }

    public void updateDestinationById(int destinationId, int updatedId, String updatedName) {
        destinationRepository.updateDestinationById(destinationId, updatedId, updatedName);
    }

}
