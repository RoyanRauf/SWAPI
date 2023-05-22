package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.models.Address;
import com.example.web.dto.AddressDto;

@Mapper
public interface AddressMapper {

    AddressDto modelToDto(Address address);
    Address dtoToModel(AddressDto addressDto);
}
