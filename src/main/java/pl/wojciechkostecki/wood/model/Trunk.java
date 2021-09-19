package pl.wojciechkostecki.wood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Trunk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double heightInCm;

    private Double widthInCm;

    @OneToOne(mappedBy = "trunk")
    @JsonBackReference
    private Tree tree;

    @OneToMany(mappedBy = "trunk")
    @JsonManagedReference
    private List<Branch> branches = new ArrayList<>();

    public void grow(Double growthFactor) {
    heightInCm *= growthFactor;
    widthInCm *= growthFactor;
    }
}
