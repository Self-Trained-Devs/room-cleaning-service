package com.roomcleaning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_service")
public class BookService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceId;
	private String userName;
	private String roomCount;
	private String Address;
	private String pinCode;
	private String fromTime;
	private String toTime;
	private String cleanerId;
	private String paymentStatus;
	private String cleaningStatus;
	
	public String getCleaningStatus() {
		return cleaningStatus;
	}

	public void setCleaningStatus(String cleaningStatus) {
		this.cleaningStatus = cleaningStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCleanerId() {
		return cleanerId;
	}

	public void setCleanerId(String cleanerId) {
		this.cleanerId = cleanerId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	private String contactNumber;

	@Override
	public String toString() {
		return "BookService [serviceId=" + serviceId + ", userName=" + userName + ", roomCount=" + roomCount
				+ ", Address=" + Address + ", pinCode=" + pinCode + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ ", cleanerId=" + cleanerId + ", paymentStatus=" + paymentStatus + ", contactNumber=" + contactNumber
				+ "]";
	}

}
