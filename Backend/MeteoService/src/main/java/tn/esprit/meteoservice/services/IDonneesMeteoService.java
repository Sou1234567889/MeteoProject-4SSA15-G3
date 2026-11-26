package tn.esprit.meteoservice.services;

import tn.esprit.meteoservice.entities.DonneesMeteo;
import java.util.List;

public interface IDonneesMeteoService {

    DonneesMeteo addDonneesMeteo(DonneesMeteo donnees);

    List<DonneesMeteo> getAllDonneesMeteo();

    DonneesMeteo getDonneesMeteoById(String id);

    List<DonneesMeteo> getDonneesMeteoByVille(String idVille);

    DonneesMeteo updateDonneesMeteo(String id, DonneesMeteo donnees);

    void deleteDonneesMeteo(String id);
}