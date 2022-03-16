package controller;

import entity.Destination;
import entity.Vacation;
import service.VacationService;

import java.util.List;

public class VacationController {

    public static final VacationService vacationService = new VacationService();

    public Vacation createVacation(int vacation_id, String name, int price, int period, String extra_details, int max_people, Destination destination) {
        return vacationService.createVacation(vacation_id, name, price, period, extra_details, max_people, destination);
    }

    public List getVacations() {
        return vacationService.getVacations();
    }

    public Vacation getVacationById(int vacationId) {
        return vacationService.getVacationById(vacationId);
    }

    public void deleteVacationById(int vacationId) {
        vacationService.deleteVacationById(vacationId);
    }

    public void updateVacationById(int vacationId, String name, int price, int period, String extra_details, int max_people) {
        vacationService.updateVacationById(vacationId, name, price, period, extra_details, max_people);
    }

    public void deleteVacationsByDestinationId(int destinationId) {
        vacationService.deleteVacationsByDestinationId(destinationId);
    }

}
