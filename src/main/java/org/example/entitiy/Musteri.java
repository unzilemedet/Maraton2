package org.example.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@NoArgsConstructor

public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isim;
    private String soyad;

    @OneToMany(mappedBy = "musteri",fetch = FetchType.EAGER)
    private List<Siparis> siparis;

    public Musteri(String isim, String soyad) {
        this.isim = isim;
        this.soyad = soyad;}


}
