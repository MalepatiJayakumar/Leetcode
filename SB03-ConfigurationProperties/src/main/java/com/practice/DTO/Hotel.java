package com.practice.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hotel {

	// To calculate value (expression language)
	@Value("#{items.idly+items.vada+items.dosa}")
	private Float billAmout;
	
	@Value("${item.info.hotelName}")
	private String hotelName;

	@Value("${item.info.location}")
	private String location;
	
	@Autowired
	private ItemInfo items;

	@Override
	public String toString() {
		return "Hotel [billAmout=" + billAmout + ", hotelName=" + hotelName + ", location=" + location + ", items="
				+ items + "]";
	}
	
}
