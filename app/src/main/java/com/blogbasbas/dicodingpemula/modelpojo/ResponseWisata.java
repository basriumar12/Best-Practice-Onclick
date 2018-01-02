package com.blogbasbas.dicodingpemula.modelpojo;

import java.util.List;
public class ResponseWisata{

	private List<WisataItem> wisata;

	private boolean success;

	private String message;

	public void setWisata(List<WisataItem> wisata){
		this.wisata = wisata;
	}

	public List<WisataItem> getWisata(){
		return wisata;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseWisata{" + 
			"wisata = '" + wisata + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}