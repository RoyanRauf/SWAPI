package com.example.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.models.People;
import com.example.models.People;
import com.example.web.dto.PersonCreateRequest;
import com.example.web.dto.PersonResponse;
import com.example.web.dto.PersonUpdateRequest;

@Mapper(uses = AddressMapper.class)
public interface PersonMapper {

    @Mapping(target = "url", ignore = true)
    @Mapping(target = "name", ignore = true)
    People modelFromCreateRequest(PersonCreateRequest personCreateDto);

    PersonResponse responseFromModel(People people);

    @Mapping(target = "photos", ignore = true)
    @Mapping(target = "egnNumber", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "age", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "address", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PersonUpdateRequest personUpdateDto, @MappingTarget People people);

    List<PersonResponse> listOfModelToListOfDto(Iterable<People> persons);
}
