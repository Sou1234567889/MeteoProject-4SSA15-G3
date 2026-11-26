package tn.esprit.meteoservice.services;

import tn.esprit.meteoservice.entities.Prevision;
import java.util.List;

public interface IPrevisionService {

    Prevision addPrevision(Prevision prevision);

    List<Prevision> getAllPrevisions();

    Prevision getPrevisionById(String id);

    List<Prevision> getPrevisionsByVille(String idVille);

    Prevision updatePrevision(String id, Prevision prevision);

    void deletePrevision(String id);
}