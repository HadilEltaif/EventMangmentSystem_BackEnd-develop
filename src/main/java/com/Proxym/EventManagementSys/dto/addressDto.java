package com.Proxym.EventManagementSys.dto;

import com.Proxym.EventManagementSys.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class addressDto {
    private String country;
    private String town;
    private String ZIP_code;

    public static addressDto fromEntity(Address address){
        if(address==null){
            return null;
            //TODO throw new exception
        }
        return addressDto.builder().country(address.getCountry())
                .town(address.getTown())
                .ZIP_code(address.getZIP_code()).build();
    }
    public Address toEntity(addressDto addressDto)
    {
        if(addressDto==null)
        {
            return null;
            //TODO throw new exception
        }

        Address address = new Address();
        address.setCountry(addressDto.getCountry());
        address.setTown(addressDto.getTown());
        address.setZIP_code(addressDto.getZIP_code());
        return address;
    }
}
