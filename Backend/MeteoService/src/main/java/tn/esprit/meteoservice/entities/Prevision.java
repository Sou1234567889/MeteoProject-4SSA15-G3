
package tn.esprit.meteoservice.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.meteoservice.enums.ConditionMeteo;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "previsions")
public class Prevision {

    @Id
    private String id;

    private String idVille;

    private LocalDate date;

    private double tempMin;

    private double tempMax;

    private ConditionMeteo condition;

    private double probabilitePluie;
}
