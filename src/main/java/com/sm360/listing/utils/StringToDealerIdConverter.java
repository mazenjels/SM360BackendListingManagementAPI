package com.sm360.listing.utils;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.sm360.listing.models.DealerId;

@Component
public class StringToDealerIdConverter implements Converter<String, DealerId>{

	@Override
	public DealerId convert(@NonNull String dealerId) {
		// TODO Auto-generated method stub
		return new DealerId(UUID.fromString(dealerId));
	}

}
