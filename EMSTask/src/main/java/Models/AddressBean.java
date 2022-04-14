package Models;

import java.io.Serializable;

public class AddressBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int AddressId;
	private String AddressLineOne;
	private String AddressLineTwo;
	private String Pincode;
	private String City;
	private String State;
	private int Userid;

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public String getAddressLineOne() {
		return AddressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		AddressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return AddressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		AddressLineTwo = addressLineTwo;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

}
