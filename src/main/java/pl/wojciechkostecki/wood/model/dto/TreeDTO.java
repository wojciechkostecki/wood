package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.Trunk;

@Data
public class TreeDTO {
    private Long id;

    private String name;

    private Trunk trunk;

    private Integer ageInYears;

}
