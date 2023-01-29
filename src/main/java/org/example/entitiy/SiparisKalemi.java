package org.example.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Urun urun;

    private int adet;

    public SiparisKalemi(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;

    }


}
