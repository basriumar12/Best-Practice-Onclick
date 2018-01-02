package com.blogbasbas.dicodingpemula.modelpojo;


import com.google.gson.annotations.SerializedName;


public class WisataItem{

	@SerializedName("gambar4")
	private String gambar4;

	@SerializedName("longitude_wisata")
	private String longitudeWisata;

	@SerializedName("id_wisata")
	private String idWisata;

	@SerializedName("gambar1")
	private String gambar1;

	@SerializedName("gambar3")
	private String gambar3;

	@SerializedName("latitude_wisata")
	private String latitudeWisata;

	@SerializedName("gambar2")
	private String gambar2;

	@SerializedName("nama_wisata")
	private String namaWisata;

	@SerializedName("gambar_wisata")
	private String gambarWisata;

	@SerializedName("deksripsi_wisata")
	private String deksripsiWisata;

	@SerializedName("alamat_wisata")
	private String alamatWisata;

	@SerializedName("event_wisata")
	private String eventWisata;

	public void setGambar4(String gambar4){
		this.gambar4 = gambar4;
	}

	public String getGambar4(){
		return gambar4;
	}

	public void setLongitudeWisata(String longitudeWisata){
		this.longitudeWisata = longitudeWisata;
	}

	public String getLongitudeWisata(){
		return longitudeWisata;
	}

	public void setIdWisata(String idWisata){
		this.idWisata = idWisata;
	}

	public String getIdWisata(){
		return idWisata;
	}

	public void setGambar1(String gambar1){
		this.gambar1 = gambar1;
	}

	public String getGambar1(){
		return gambar1;
	}

	public void setGambar3(String gambar3){
		this.gambar3 = gambar3;
	}

	public String getGambar3(){
		return gambar3;
	}

	public void setLatitudeWisata(String latitudeWisata){
		this.latitudeWisata = latitudeWisata;
	}

	public String getLatitudeWisata(){
		return latitudeWisata;
	}

	public void setGambar2(String gambar2){
		this.gambar2 = gambar2;
	}

	public String getGambar2(){
		return gambar2;
	}

	public void setNamaWisata(String namaWisata){
		this.namaWisata = namaWisata;
	}

	public String getNamaWisata(){
		return namaWisata;
	}

	public void setGambarWisata(String gambarWisata){
		this.gambarWisata = gambarWisata;
	}

	public String getGambarWisata(){
		return gambarWisata;
	}

	public void setDeksripsiWisata(String deksripsiWisata){
		this.deksripsiWisata = deksripsiWisata;
	}

	public String getDeksripsiWisata(){
		return deksripsiWisata;
	}

	public void setAlamatWisata(String alamatWisata){
		this.alamatWisata = alamatWisata;
	}

	public String getAlamatWisata(){
		return alamatWisata;
	}

	public void setEventWisata(String eventWisata){
		this.eventWisata = eventWisata;
	}

	public String getEventWisata(){
		return eventWisata;
	}

	@Override
 	public String toString(){
		return 
			"WisataItem{" + 
			"gambar4 = '" + gambar4 + '\'' + 
			",longitude_wisata = '" + longitudeWisata + '\'' + 
			",id_wisata = '" + idWisata + '\'' + 
			",gambar1 = '" + gambar1 + '\'' + 
			",gambar3 = '" + gambar3 + '\'' + 
			",latitude_wisata = '" + latitudeWisata + '\'' + 
			",gambar2 = '" + gambar2 + '\'' + 
			",nama_wisata = '" + namaWisata + '\'' + 
			",gambar_wisata = '" + gambarWisata + '\'' + 
			",deksripsi_wisata = '" + deksripsiWisata + '\'' + 
			",alamat_wisata = '" + alamatWisata + '\'' + 
			",event_wisata = '" + eventWisata + '\'' + 
			"}";
		}
}