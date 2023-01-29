package org.example.service;

import org.example.entitiy.Musteri;
import org.example.entitiy.Siparis;
import org.example.entitiy.SiparisKalemi;
import org.example.repository.MusteriRepository;
import org.example.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MusteriService {

    MusteriRepository musteriRepository = new MusteriRepository();

    public void MusterileriListele(){
        List<Musteri> musteriList = musteriRepository.getAll();

        for(Musteri  m : musteriList){
            int toplam = 0;
            System.out.println("Müşteri Id: " + m.getId()+"  Müşteri Ad: "+m.getIsim()+" Müşteri Soyad:  "+m.getSoyad());
            for(Siparis s : m.getSiparis()) {
                System.out.println("  Sipariş Id: "+s.getId());
                for(SiparisKalemi sk : s.getSiparisKalemi()){
                    System.out.println("    Ürün: " + sk.getUrun().getUrunAdi() + " Fiyat: " + sk.getUrun().getFiyat() +" Adet:"+ sk.getAdet());
                    toplam = toplam + sk.getAdet() * sk.getUrun().getFiyat();
                }

            }
            System.out.println(" Toplam Harcama : "+toplam);
        }
    }
   public void soru2C() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

            siparisList = entityManager.createNativeQuery("SELECT m.id, count(musteri_id) FROM siparis as s\n" +
                    "inner join musteri as m on s.musteri_id=m.id\n" +
                    "GROUP BY m.id").getResultList();
            for (Object[] item : siparisList) {

                System.out.println("MüşteriId: " + item[0] +  " Siparişsayısı: " + item[1] );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void soru2D() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            siparisList = entityManager.createNativeQuery(" SELECT m.name, m.surname, s.id FROM musteri as m\n" +
                    "inner join siparis as s ON m.id = s.musteri_id;").getResultList();
            for (Object[] item : siparisList) {

                System.out.println(" Müşteri Ad: " + item[0] + " Müşteri Soyad: " + item[1] + " Sipariş ID: " + item[2]);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
