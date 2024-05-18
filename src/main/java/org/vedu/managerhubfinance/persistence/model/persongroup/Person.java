package org.vedu.managerhubfinance.persistence.model.persongroup;

import org.vedu.managerhubfinance.persistence.model.PersonAccount;
import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.listeners.PersonListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@EntityListeners({PersonListener.class})
@Table(name = "person")
@Entity
public class Person extends PropertiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Basic
    @Column(name = "type", nullable = false, length = 1)
    private String type;

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Basic
    @Column(name = "site", nullable = false, length = 50)
    private String site;

    @Basic
    @Column(name = "customer", nullable = false, length = 1)
    private String customer;

    @Basic 
    @Column(name = "supplier", nullable = false, length = 1)
    private String supplier;

    @Basic 
    @Column(name = "carrier", nullable = false, length = 1)
    private String carrier;

    @Basic
    @Column(name = "employee", nullable = false, length = 1)
    private String employee;

    @Basic
    @Column(name = "accountant", nullable = false, length = 1)
    private String accountant;
    
    @OneToOne(mappedBy = "person")
    private PersonAccount account;
}
