package co.edu.unbosque.viajesglobalback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;

@JsonRootName(value = "CustomerCredentials")
public class CustomerCredentialsDTO {
    private CustomerDTO customer;
    @JsonProperty("password")
    @NotBlank
    private String password;

    public CustomerCredentialsDTO() {

    }

    public CustomerCredentialsDTO(CustomerDTO customer, String password) {
        this.customer = customer;
        this.password = password;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}
