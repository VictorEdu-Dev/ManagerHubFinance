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
		"personAddress"})
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
    
    @Basic
    @Column(name = "nickname", length = 100)
    private String nickname;
    
    @Basic
    @Column(name = "code", length = 100)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 15)
    private PersonType type;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<PersonContact> personContact;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_address_id", nullable = false)
    private PersonAddress personAddress;
}
