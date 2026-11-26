
package tn.esprit.meteoservice.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.meteoservice.enums.ConditionMeteo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "donnees_meteo")
public class DonneesMeteo {

    @Id
    private String id;

    private String idVille;
    private double temperature;
    private double humidite;
    private double vitesseVent;
    private ConditionMeteo condition;
    private double qualiteAir;
    private double uvIndex;
}
