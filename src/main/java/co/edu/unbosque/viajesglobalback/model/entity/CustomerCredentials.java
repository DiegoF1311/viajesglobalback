package co.edu.unbosque.viajesglobalback.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_credentials")
public class CustomerCredentials {
    @Id
    @Column(name = "credential_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @Column(name = "password", nullable = false)
    private String password;

    public CustomerCredentials() {

    }

    public CustomerCredentials(Customer customer, String password) {
        this.customer = customer;
        this.password = password;
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
