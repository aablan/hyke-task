package com.axiom.hyketask;

import com.axiom.hyketask.repository.mongo.MobileHandsetEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("embedded_mongo")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MobileHandSetControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeAll
    void init() throws IOException {
        var objectMapper = new ObjectMapper();
        var data = objectMapper.readValue(new File("src/test/resources/data.json"), MobileHandsetEntity[].class);
        mongoTemplate.insertAll(Arrays.asList(data));
    }

    @Test
    void testGetMobileData_WhenNoFilterApplied() {
        var url = "/v1/mobile/search";
        //@formatter:off
        given()
                .port(port)
        .when()
                .get(url).prettyPeek()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(105));
        //@formatter:on

    }

    @Test
    void testGetMobileData_WhenFilterByPrice() {
        var url = "/v1/mobile/search?price=200";
        //@formatter:off
        given()
                .port(port)
        .when()
                .get(url).prettyPeek()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(10));
        //@formatter:on

    }

    @Test
    void testGetMobileData_WhenFilterByPriceAndAnnounceDate() {
        var url = "/v1/mobile/search?announceDate=1999&price=200";
        //@formatter:off
        given()
                .port(port)
        .when()
                .get(url).prettyPeek()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(2))
                .body("itemNum[0]", is(28354))
                .body("brand[0]", is("Ericsson"))
                .body("phone[0]", is("Ericsson A1018s"))
                .body("picture[0]", is("https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif"))
                .body("release[0].announceDate", is("1999"))
                .body("release[0].priceEur", is(200))
                .body("sim[0]", is("Mini-SIM"))
                .body("resolution[0]", is("3 x 12 chars"))
                .body("hardware[0].audioJack", is("No"))
                .body("hardware[0].gps", is("No"))
                .body("hardware[0].battery", is("Removable NiMH 800 mAh battery"))
                .body("itemNum[1]", is(26894))
                .body("brand[1]", is("Ericsson"))
                .body("phone[1]", is("Ericsson I 888"))
                .body("picture[1]", is("https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif"))
                .body("release[1].announceDate", is("1999"))
                .body("release[1].priceEur", is(200))
                .body("sim[1]", is("Mini-SIM"))
                .body("resolution[1]", is("3 x 12 chars"))
                .body("hardware[1].audioJack", is("No"))
                .body("hardware[1].gps", is("No"))
                .body("hardware[1].battery", is("Removable NiMH 800 mAh battery"))

        ;
        //@formatter:on

    }

    @Test
    void testGetMobileData_WhenInvalidFilterApplied() {
        var url = "/v1/mobile/search?invalid=02545&test";
        //@formatter:off
        given()
                .port(port)
        .when()
                .get(url).prettyPeek()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(105));
        //@formatter:on

    }

    @Test
    void testGetMobileData_WhenFilterCriteriaDontMatch() {
        var url = "/v1/mobile/search?price=2000";
        //@formatter:off
        given()
                .port(port)
        .when()
                .get(url).prettyPeek()
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(0));
        //@formatter:on

    }


}
