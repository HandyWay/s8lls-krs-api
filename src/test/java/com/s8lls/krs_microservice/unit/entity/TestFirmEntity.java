package com.s8lls.krs_microservice.unit.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.s8lls.krs_microservice.entity.FirmResponse;
import com.s8lls.krs_microservice.entity.FirmResponse.Firm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFirmEntity {

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    @Test
    public void testJsonSerialization() throws JsonProcessingException {
        Firm firm = new Firm();
        firm.setUid("123");
        firm.setNip("7171642051");
        firm.setName("Michał Czapczyński C-SOLUTIONS");
        firm.setFirstname("Michał");
        firm.setLastname("Czapczyński");
        firm.setStreet("Testowa");
        firm.setStreetNumber("10");
        firm.setHouseNumber("2");
        firm.setCity("Warszawa");
        firm.setPostCode("00-001");
        firm.setPostCity("Warszawa");

        FirmResponse response = new FirmResponse();
        response.setFirm(firm);
        String json = jsonMapper.writeValueAsString(response);
        System.out.println("JSON Output:\n" + json);
        assertTrue(json.contains("\"nip\":\"7171642051\""));
        assertTrue(json.contains("\"name\":\"Michał Czapczyński C-SOLUTIONS\""));
    }

    @Test
    public void testJsonDeserialization() throws JsonProcessingException {
        String json = """
            {
                "firm": {
                    "uid": "123",
                    "nip": "7171642051",
                    "name": "Michał Czapczyński C-SOLUTIONS",
                    "firstname": "Michał",
                    "lastname": "Czapczyński",
                    "street": "Testowa",
                    "streetNumber": "10",
                    "houseNumber": "2",
                    "city": "Warszawa",
                    "postCode": "00-001",
                    "postCity": "Warszawa"
                }
            }
        """;

        FirmResponse response = jsonMapper.readValue(json, FirmResponse.class);
        assertNotNull(response);
        assertNotNull(response.getFirm());
        assertEquals("7171642051", response.getFirm().getNip());
        assertEquals("Michał Czapczyński C-SOLUTIONS", response.getFirm().getName());
    }

    @Test
    public void testXmlSerialization() throws JsonProcessingException {

        Firm firm = new Firm();
        firm.setUid("123");
        firm.setNip("7171642051");
        firm.setName("Michał Czapczyński C-SOLUTIONS");
        firm.setFirstname("Michał");
        firm.setLastname("Czapczyński");
        firm.setStreet("Testowa");
        firm.setStreetNumber("10");
        firm.setHouseNumber("2");
        firm.setCity("Warszawa");
        firm.setPostCode("00-001");
        firm.setPostCity("Warszawa");

        FirmResponse response = new FirmResponse();
        response.setFirm(firm);
        String xml = xmlMapper.writeValueAsString(response);
        System.out.println("XML Output:\n" + xml);
        assertTrue(xml.contains("<nip>7171642051</nip>"));
        assertTrue(xml.contains("<name>Michał Czapczyński C-SOLUTIONS</name>"));
    }

    @Test
    public void testXmlDeserialization() throws JsonProcessingException {
        String xml = """
            <FirmResponse>
                <firm>
                    <uid>123</uid>
                    <nip>7171642051</nip>
                    <name>Michał Czapczyński C-SOLUTIONS</name>
                    <firstname>Michał</firstname>
                    <lastname>Czapczyński</lastname>
                    <street>Testowa</street>
                    <streetNumber>10</streetNumber>
                    <houseNumber>2</houseNumber>
                    <city>Warszawa</city>
                    <postCode>00-001</postCode>
                    <postCity>Warszawa</postCity>
                </firm>
            </FirmResponse>
        """;

        FirmResponse response = xmlMapper.readValue(xml, FirmResponse.class);

        assertNotNull(response);
        assertNotNull(response.getFirm());
        assertEquals("7171642051", response.getFirm().getNip());
        assertEquals("Michał Czapczyński C-SOLUTIONS", response.getFirm().getName());
    }
}

