package pl.wojciechkostecki.wood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Leaf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TypeLeaf typeLeaf;

    private Double lengthInMm;

    private Double widthInMm;

    @ManyToOne
    @JsonBackReference
    private Branch branch;

    public void grow(Double growthFactor) {
        lengthInMm *= growthFactor;
        widthInMm *= growthFactor;
    }

}
