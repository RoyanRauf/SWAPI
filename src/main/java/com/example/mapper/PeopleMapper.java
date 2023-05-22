package com.example.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.models.People;
import com.example.web.dto.PeopleCreateRequest;
import com.example.web.dto.PeopleResponse;
import com.example.web.dto.PersonUpdateRequest;

@Mapper(uses = AddressMapper.class)
public interface PeopleMapper {

    @Mapping(target = "url", ignore = true)
    @Mapping(target = "name", ignore = true)
    People modelFromCreateRequest(PeopleCreateRequest personCreateDto);

    PeopleResponse responseFromModel(People people);

    @Mapping(target = "photos", ignore = true)
    @Mapping(target = "egnNumber", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "age", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "address", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PersonUpdateRequest personUpdateDto, @MappingTarget People people);

    List<PeopleResponse> listOfModelToListOfDto(Iterable<People> persons);
}
