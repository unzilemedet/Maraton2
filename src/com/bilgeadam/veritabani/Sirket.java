package com.bilgeadam.veritabani;

public class Sirket {
	private int id;
  

	private String sirketİsmi;
    private String sirketSahibi;
    private String unvan;
    private String faaliyetAlani;
    private int kurulusYili;
    
    
	public Sirket(int id, String sirketİsmi, String sirketSahibi, String unvan, String faaliyetAlani, int kurulusYili) {
		super();
		this.id = id;
		this.sirketİsmi = sirketİsmi;
		this.sirketSahibi = sirketSahibi;
		this.unvan = unvan;
		this.faaliyetAlani = faaliyetAlani;
		this.kurulusYili = kurulusYili;
	}
    
	public Sirket(String sirketİsmi, String sirketSahibi, String unvan, String faaliyetAlani, int kurulusYili) {
		super();
		this.sirketİsmi = sirketİsmi;
		this.sirketSahibi = sirketSahibi;
		this.unvan = unvan;
		this.faaliyetAlani = faaliyetAlani;
		this.kurulusYili = kurulusYili;
	}
	@Override
	public String toString() {
		return "Sirket [id=" + id + ", sirketİsmi=" + sirketİsmi + ", sirketSahibi=" + sirketSahibi + ", unvan=" + unvan
				+ ", faaliyetAlani=" + faaliyetAlani + ", kurulusYili=" + kurulusYili + "]";
	}
	public String getSirketİsmi() {
		return sirketİsmi;
	}
	public void setSirketİsmi(String sirketİsmi) {
		this.sirketİsmi = sirketİsmi;
	}
	public String getSirketSahibi() {
		return sirketSahibi;
	}
	public void setSirketSahibi(String sirketSahibi) {
		this.sirketSahibi = sirketSahibi;
	}
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		unvan = unvan;
	}
	public String getFaaliyetAlani() {
		return faaliyetAlani;
	}
	public void setFaaliyetAlani(String faaliyetAlani) {
		this.faaliyetAlani = faaliyetAlani;
	}
	public int getKurulusYili() {
		return kurulusYili;
	}
	public void setKurulusYili(int kurulusYili) {
		this.kurulusYili = kurulusYili;
	}


}
