package controller;

import entity.Destination;
import repository.DestinationRepository;
import service.DestinationService;

import java.util.List;

public class DestinationController {


    public static final DestinationService destinationService = new DestinationService();

    public Destination CreateDestination(int destination_id, String destinationName) {
        return destinationService.CreateDestination(destination_id, destinationName);
    }

    public List getDestinations() {
        return destinationService.getDestinations();
    }

    public Destination getDestinationById(int destinationId) {
        return destinationService.getDestinationById(destinationId);
    }

    public void updateDestinationById(int destinationId, int updatedId, String updatedName) {
        destinationService.updateDestinationById(destinationId, updatedId, updatedName);
    }

    public void deleteDestinationById(int destinationId) {
        destinationService.deleteDestinationById(destinationId);
    }




}
