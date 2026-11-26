package tn.esprit.meteoservice.services;

import tn.esprit.meteoservice.entities.HistoriqueMeteo;
import java.util.List;

public interface IHistoriqueMeteoService {

    HistoriqueMeteo addHistorique(HistoriqueMeteo historique);

    List<HistoriqueMeteo> getAllHistoriques();

    HistoriqueMeteo getHistoriqueById(String id);

    List<HistoriqueMeteo> getHistoriquesByVille(String idVille);

    HistoriqueMeteo updateHistorique(String id, HistoriqueMeteo historique);

    void deleteHistorique(String id);
}