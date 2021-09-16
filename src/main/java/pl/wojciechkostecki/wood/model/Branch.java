package pl.wojciechkostecki.wood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double lengthInCm;

    @ManyToOne
    @JsonBackReference
    private Trunk trunk;

    @ManyToOne
    private Branch largeBranch;

    @OneToMany(mappedBy = "largeBranch")
    private List<Branch> smallBranches;

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    private List<Leaf> leaves = new ArrayList<>();

}
