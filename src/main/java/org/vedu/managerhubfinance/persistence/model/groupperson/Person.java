package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.listeners.PersonListener;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(exclude = {
		"personContact",
		"personPhone", 
		"personAddress", 
		"customer", 
		"supplier", 
		"carrier", 
		"accountant"})
@Builder
@EntityListeners({PersonListener.class})
@Table(name = "person")
@Entity
public class Person extends PropertiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Basic
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 10)
    private PersonType type;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<PersonContact> personContact;
    
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<PersonPhone> personPhone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_address_id", nullable = false)
    private PersonAddress personAddress;

    @Basic
    @Column(name = "site", nullable = false, length = 100)
    private String site;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Supplier supplier;

    @OneToOne(mappedBy = "carrier", fetch = FetchType.LAZY)
    private Carrier carrier;

    @Basic
    @Column(name = "employee", nullable = false, length = 1)
    private String employee;

    @OneToOne(mappedBy = "accountant", fetch = FetchType.LAZY)
    private Accountant accountant;
}
