package com.eden.dto;

public class ServiceProviderLookupDto {
	public String displayName;
	public String type;
	public String bookingOffice;
	public String ref;

	public ServiceProviderLookupDto(String displayName, String ref, String type, String bookingOffice) {
		this.displayName = displayName;
		this.type = type;
		this.bookingOffice = bookingOffice;
		this.ref = ref;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBookingOffice() {
		return bookingOffice;
	}

	public void setBookingOffice(String bookingOffice) {
		this.bookingOffice = bookingOffice;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
