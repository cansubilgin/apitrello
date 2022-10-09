package trello.com;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Method {

    public String createBoard() {
        RestAssured.baseURI = "https://trello.com";
        String body =
                "{\"name\":\"cCANS\",\"defaultLists\":true,\"idOrganization\":\"634196fc8525ba020c9126c3\",\"prefs_background_url\":\"https://images.unsplash.com/photo-1665001423954-df4c8c0d564a?ixid=Mnw3MDY2fDB8MXxjb2xsZWN0aW9ufDF8MzE3MDk5fHx8fHwyfHwxNjY1MjQyOTI4&ixlib=rb-1.2.1&w=2560&h=2048&q=90\",\"prefs_permissionLevel\":\"org\",\"prefs_selfJoin\":true,\"token\":\"634196e1339dc203f7e21799/ATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13\"}";
        Response response1 = given()
                .header("Cookie", "dsc=c35a98cc513fda8c62ec7aa3f3f8b655fc29c67d7b7b0899548a14ffc5465972; lang=tr-TR; ajs_anonymous_id=%22c1c6e8a9-4e72-4468-82d8-bb6ce1dccc78%22; _sp_ses.dc4d=*; _sp_id.dc4d=158d5f0c-af01-4e84-8479-a8fee5d2f007.1665243275.1.1665244137.1665243275.197325b6-e29d-4422-92d3-637dc1b00003; G_ENABLED_IDPS=google; mab=634196e1339dc203f7e21799; gdpr-cookie-consent=accepted; __cid=n5vf3Ango2eX1HEMBKX3TakNt8ZaK1Xwr9AK7bjUcp-BhVTKKtEFja_pK_WZ2Tjg6yUGoq6sWSQLhgOfP9MOsqDQPYn8nGmXxb1qjIPkKN2M-VGEwrVpmt_xSLmM4DbDnOomusW_MNmX8X7bmOomn9rrN92Z_zbEjJZjjse-Kd-c4DbdneE3zeq4dIjKvn7CneEzw5y9Do6esjSJyOA2lyfQkuXK5WPanecyiTDtR6PrnUPNhJhomcm9Ks3lv3KIwPlUxIyZQs3ro2edxLhlnoyVb5_JsnLe6OA3zdqiWdjz4Sad344zspz4ov6c4Cjdnf831JvhJt2e6zbdluE2QqTRs8gX0cN-6BoEPqwMou1L0e3sW-TNuGEP-ezoOQZyrGXGR6zRBkesEwZVC2mqXAtjq1TYaHKj65F-7azRBi8EBa5e1oFGveOMU3MyiV6v7GavTozGB-270QbprC4; token=634196e1339dc203f7e21799%2FATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13; hasAccount=atlassian; loggedIn=1; preAuthProps=s%3A634196e1339dc203f7e21799%3AisEnterpriseAdmin%3Dfalse.kSWEt%2FaSm25zVh3SNaPaPU7KkwiT2YChYyJknLjHCdo")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .log().all()
                .request("POST", "/1/boards")
                .then()
                .extract().response();

        String responseBody = response1.getBody().asString();
        System.out.println("Response Body is" + responseBody);
        System.out.println("Status code is: " + response1.getStatusCode());
        Assert.assertEquals(response1.getStatusCode(), 200);
        return response1.jsonPath().getString("id");
    }
    public String createTask(String boardId) {
        RestAssured.baseURI = "https://trello.com";
        String body =
                "{\"name\":\"canssss\",\"closed\":false,\"idLabels\":[],\"idMembers\":[],\"dateLastActivity\":1665313166602,\"pos\":65535,\"cardRole\":null,\"idBoard\":"+boardId+",\"idList\":\"6342a935a5e65605bc945398\",\"token\":\"634196e1339dc203f7e21799/ATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13\"}";
        Response response1 = given()
                .header("Cookie", "dsc=c35a98cc513fda8c62ec7aa3f3f8b655fc29c67d7b7b0899548a14ffc5465972; lang=tr-TR; ajs_anonymous_id=%22c1c6e8a9-4e72-4468-82d8-bb6ce1dccc78%22; _sp_ses.dc4d=*; _sp_id.dc4d=158d5f0c-af01-4e84-8479-a8fee5d2f007.1665243275.1.1665244137.1665243275.197325b6-e29d-4422-92d3-637dc1b00003; G_ENABLED_IDPS=google; mab=634196e1339dc203f7e21799; gdpr-cookie-consent=accepted; __cid=n5vf3Ango2eX1HEMBKX3TakNt8ZaK1Xwr9AK7bjUcp-BhVTKKtEFja_pK_WZ2Tjg6yUGoq6sWSQLhgOfP9MOsqDQPYn8nGmXxb1qjIPkKN2M-VGEwrVpmt_xSLmM4DbDnOomusW_MNmX8X7bmOomn9rrN92Z_zbEjJZjjse-Kd-c4DbdneE3zeq4dIjKvn7CneEzw5y9Do6esjSJyOA2lyfQkuXK5WPanecyiTDtR6PrnUPNhJhomcm9Ks3lv3KIwPlUxIyZQs3ro2edxLhlnoyVb5_JsnLe6OA3zdqiWdjz4Sad344zspz4ov6c4Cjdnf831JvhJt2e6zbdluE2QqTRs8gX0cN-6BoEPqwMou1L0e3sW-TNuGEP-ezoOQZyrGXGR6zRBkesEwZVC2mqXAtjq1TYaHKj65F-7azRBi8EBa5e1oFGveOMU3MyiV6v7GavTozGB-270QbprC4; token=634196e1339dc203f7e21799%2FATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13; hasAccount=atlassian; loggedIn=1; preAuthProps=s%3A634196e1339dc203f7e21799%3AisEnterpriseAdmin%3Dfalse.kSWEt%2FaSm25zVh3SNaPaPU7KkwiT2YChYyJknLjHCdo")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .log().all()
                .request("POST", "/1/cards")
                .then()
                .extract().response();

        String responseBody = response1.getBody().asString();
        System.out.println("Response Body is" + responseBody);
        System.out.println("Status code is: " + response1.getStatusCode());
        Assert.assertEquals(response1.getStatusCode(), 200);
        return response1.jsonPath().getString("id");
    }public void deleteTask(String getId) {
        RestAssured.baseURI = "https://trello.com";
        String body =
                "{\"token\":\"634196e1339dc203f7e21799/ATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13\"}";
        Response response1 = given()
                .header("Cookie", "dsc=c35a98cc513fda8c62ec7aa3f3f8b655fc29c67d7b7b0899548a14ffc5465972; lang=tr-TR; ajs_anonymous_id=%22c1c6e8a9-4e72-4468-82d8-bb6ce1dccc78%22; _sp_ses.dc4d=*; _sp_id.dc4d=158d5f0c-af01-4e84-8479-a8fee5d2f007.1665243275.1.1665244137.1665243275.197325b6-e29d-4422-92d3-637dc1b00003; G_ENABLED_IDPS=google; mab=634196e1339dc203f7e21799; gdpr-cookie-consent=accepted; __cid=n5vf3Ango2eX1HEMBKX3TakNt8ZaK1Xwr9AK7bjUcp-BhVTKKtEFja_pK_WZ2Tjg6yUGoq6sWSQLhgOfP9MOsqDQPYn8nGmXxb1qjIPkKN2M-VGEwrVpmt_xSLmM4DbDnOomusW_MNmX8X7bmOomn9rrN92Z_zbEjJZjjse-Kd-c4DbdneE3zeq4dIjKvn7CneEzw5y9Do6esjSJyOA2lyfQkuXK5WPanecyiTDtR6PrnUPNhJhomcm9Ks3lv3KIwPlUxIyZQs3ro2edxLhlnoyVb5_JsnLe6OA3zdqiWdjz4Sad344zspz4ov6c4Cjdnf831JvhJt2e6zbdluE2QqTRs8gX0cN-6BoEPqwMou1L0e3sW-TNuGEP-ezoOQZyrGXGR6zRBkesEwZVC2mqXAtjq1TYaHKj65F-7azRBi8EBa5e1oFGveOMU3MyiV6v7GavTozGB-270QbprC4; token=634196e1339dc203f7e21799%2FATTSxvbGTIFooA3sL4RzEym1I9xVz5uaEevjTzqqMih4El7BNZTqZsd3AbJRCA7qNbsh263EAB13; hasAccount=atlassian; loggedIn=1; preAuthProps=s%3A634196e1339dc203f7e21799%3AisEnterpriseAdmin%3Dfalse.kSWEt%2FaSm25zVh3SNaPaPU7KkwiT2YChYyJknLjHCdo")
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .log().all()
                .request("DELETE", "/1/cards/"+getId)
                .then()
                .extract().response();

        String responseBody = response1.getBody().asString();
        System.out.println("Response Body is" + responseBody);
        System.out.println("Status code is: " + response1.getStatusCode());
        Assert.assertEquals(response1.getStatusCode(), 200);
        String Id = response1.jsonPath().getString("id");
        System.out.println(Id);

    }


}
