package com.bozntouran.car_database_reviews_rest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    private String brandName;
    @NotNull
    @NotBlank
    private String countryOfOrigin;
    @Min(value = 1800)
    private Integer creationYear;


//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "carBrand",cascade = CascadeType.ALL)
//    private Set<CarModel> models = new HashSet<>();
//
//    public void addCarModelToBrand(CarModel carModel){
//
//        this.models.add(carModel);
//        carModel.setCarBrand(this);
//    }

}
