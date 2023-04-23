package com.org.myapp.api.controller;

import com.org.myapp.domain.service.addressValidator.AddressValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private AddressValidatorService addressValidatorService;

    @Autowired
    public AddressController(AddressValidatorService addressValidatorService) {
        this.addressValidatorService = addressValidatorService;
    }

    @GetMapping
    @RequestMapping(value = "/states")
    public ResponseEntity getUSStates(){
        return ResponseEntity.ok(this.addressValidatorService.getUSStates());
    }

    @GetMapping
    @RequestMapping(value = "/zipCodes")
    public ResponseEntity getZipCodesByState(@RequestParam(required = true) String state){
        return ResponseEntity.ok(this.addressValidatorService.getZipCodesByState(state));
    }

    @GetMapping
    @RequestMapping(value = "/cities")
    public ResponseEntity getCitiesByState(@RequestParam(required = true) String state){
        return ResponseEntity.ok(this.addressValidatorService.getCitiesByState(state));
    }

}
