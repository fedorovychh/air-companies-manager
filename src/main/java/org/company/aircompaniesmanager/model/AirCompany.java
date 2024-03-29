package org.company.aircompaniesmanager.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "air_companies")
@SQLDelete(sql = "UPDATE air_companies SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 72)
    private String name;

    @Column(nullable = false, length = 56)
    private String companyType;

    @Column(nullable = false)
    private LocalDate foundationDate;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;

    public AirCompany() {
    }

    public AirCompany(Long id) {
        this.id = id;
    }
}
