package com.s8lls.krs_microservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "FirmResponse")
public class FirmResponse {

    @JacksonXmlProperty(localName = "firm")
    @JsonProperty("firm")
    private Firm firm;

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public static class Firm {
        @JacksonXmlProperty(localName = "uid")
        @JsonProperty("uid")
        private String uid;

        @JacksonXmlProperty(localName = "nip")
        @JsonProperty("nip")
        private String nip;

        @JacksonXmlProperty(localName = "name")
        @JsonProperty("name")
        private String name;

        @JacksonXmlProperty(localName = "firstname")
        @JsonProperty("firstname")
        private String firstname;

        @JacksonXmlProperty(localName = "lastname")
        @JsonProperty("lastname")
        private String lastname;

        @JacksonXmlProperty(localName = "street")
        @JsonProperty("street")
        private String street;

        @JacksonXmlProperty(localName = "streetNumber")
        @JsonProperty("streetNumber")
        private String streetNumber;

        @JacksonXmlProperty(localName = "houseNumber")
        @JsonProperty("houseNumber")
        private String houseNumber;

        @JacksonXmlProperty(localName = "city")
        @JsonProperty("city")
        private String city;

        @JacksonXmlProperty(localName = "postCode")
        @JsonProperty("postCode")
        private String postCode;

        @JacksonXmlProperty(localName = "postCity")
        @JsonProperty("postCity")
        private String postCity;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNip() {
            return nip;
        }

        public void setNip(String nip) {
            this.nip = nip;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getPostCity() {
            return postCity;
        }

        public void setPostCity(String postCity) {
            this.postCity = postCity;
        }
    }
}
