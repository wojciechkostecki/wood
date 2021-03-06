package pl.wojciechkostecki.wood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double lengthInCm;

    @ManyToOne
    @JsonBackReference
    private Trunk trunk;

    @ManyToOne
    @JsonIgnore
    private Branch branch;

    @OneToMany(mappedBy = "branch")
    private List<Branch> branches;

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    private List<Leaf> leaves = new ArrayList<>();

    public void grow(Double growthFactor) {
        lengthInCm *= growthFactor;
    }
}
