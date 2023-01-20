package com.bilgeadam.veritabani;

public class Calisan {


	  

	private int yas;
    private int maas;
    private String departman;
    private int calısanId;
    
    
    
    
	public Calisan(int yas, int maas, String departman, int calısanId) {
		super();
		this.yas = yas;
		this.maas = maas;
		this.departman = departman;
		this.calısanId = calısanId;
	}
	@Override
	public String toString() {
		return "Calisan [yas=" + yas + ", maas=" + maas + ", departman=" + departman + ", calısanId=" + calısanId + "]";
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	public int getMaas() {
		return maas;
	}
	public void setMaas(int maas) {
		this.maas = maas;
	}
	public String getDepartman() {
		return departman;
	}
	public void setDepartman(String departman) {
		this.departman = departman;
	}
	public int getCalısanId() {
		return calısanId;
	}
	public void setCalısanId(int calısanId) {
		this.calısanId = calısanId;
	}

}
