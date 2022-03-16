package service;

import entity.Destination;
import entity.Vacation;
import repository.VacationRepository;

import java.util.List;

public class VacationService {

    public static final VacationRepository vacationRepository = new VacationRepository();

    public Vacation createVacation(int vacation_id, String name, int price, int period, String extra_details, int max_people, Destination destination) {
        return vacationRepository.createVacation(vacation_id, name, price, period, extra_details, max_people, destination);
    }

    public List getVacations() {
        return vacationRepository.getVacations();
    }

    public Vacation getVacationById(int vacationId) {
        return vacationRepository.getVacationById(vacationId);
    }

    public void deleteVacationById(int vacationId) {
        vacationRepository.deleteVacationById(vacationId);
    }

    public void updateVacationById(int vacationId, String name, int price, int period, String extra_details, int max_people) {
        vacationRepository.updateVacationById(vacationId, name, price, period, extra_details, max_people);
    }

    public void deleteVacationsByDestinationId(int destinationId) {
        vacationRepository.deleteVacationsByDestinationId(destinationId);
    }

}
