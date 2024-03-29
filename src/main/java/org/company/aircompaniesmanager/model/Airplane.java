package org.company.aircompaniesmanager.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "airplanes")
@SQLDelete(sql = "UPDATE airplanes SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 12)
    private String factorySerialNumber;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "air_company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirCompany airCompany;
    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    @Column(nullable = false, length = 56)
    private String type;
    private LocalDate creationDate;
    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;

    public Airplane() {
    }

    public Airplane(Long id) {
        this.id = id;
    }
}
