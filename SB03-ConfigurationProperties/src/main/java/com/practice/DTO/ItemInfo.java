package com.practice.DTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("items")
public class ItemInfo {

	@Value("${item.info.tiffin.idly}")
	public Float idly;
	
	@Value("${item.info.tiffin.vada}")
	public Float vada;
	
	@Value("${item.info.tiffin.dosa}")
	public Float dosa;

	@Override
	public String toString() {
		return "ItemInfo [idly=" + idly + ", vada=" + vada + ", dosa=" + dosa + "]";
	}
}