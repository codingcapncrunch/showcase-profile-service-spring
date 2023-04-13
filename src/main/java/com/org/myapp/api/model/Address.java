package com.org.myapp.api.model;

import com.org.myapp.domain.model.AddressTypeEnum;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class Address {

    @Max(value = 999999, message = "invalid address id")
    private int id;

    @NotNull(message = "address type cannot be null")
    private AddressTypeEnum type;

    @NotBlank(message = "line one cannot be blank")
    @NotNull(message = "line one cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "line one must not contain special characters")
    @Size(max = 40, message = "line one exceeds max length")
    private String lineOne;

    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "line two must not contain special characters")
    @Size(max = 40, message = "line two exceeds max length")
    private String lineTwo;

    @NotBlank(message = "city cannot be blank")
    @NotNull(message = "city cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "city must not contain special characters")
    @Size(max = 40, message = "city exceeds max length")
    private String city;

    @NotBlank(message = "state cannot be blank")
    @NotNull(message = "state cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "state must not contain special characters")
    @Size(max = 40, message = "state exceeds max length")
    private String state;

    @NotNull(message = "zip code cannot be null")
    @Max(value = 99999, message = "invalid seven digit zip code")
    @Min(value = 10000, message = "invalid seven digit zip code")
    private int zipCode;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

}
