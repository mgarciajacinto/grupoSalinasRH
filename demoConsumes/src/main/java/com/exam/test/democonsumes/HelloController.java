package com.exam.test.democonsumes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label resp1Text;
    @FXML
    private Label resp1Text1;
    @FXML
    private Label resp1Text2;

    @FXML
    protected void onHelloButtonClick() {

        resp1Text.setText(consultaServ1());
        resp1Text1.setText(consultaServ2());
        resp1Text2.setText(consultaServ3());

    }

    private String consultaServ1() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://localhost:8080/exam/empleados")
                .method("GET", body)
                .build();
        Response response = client.newCall(request).execute();
        return response.toString();
    }

    private String consultaServ2() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"date_created\": \"2022-09-15\",\r\n    \"date_form\": \"2022-09-15\",\r\n    \"date_to\": \"2022-09-15\",\r\n    \"is_active\": 1,\r\n    \"salary_per_day\": 1000,\r\n    \"contract_type_id\": 1,\r\n    \"employee_id\": 2\r\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/exam/empleado/contrato")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.toString();
    }

    private String consultaServ3() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"employee_id\": 3,\r\n    \"birth_date\": \"1994-06-03\",\r\n    \"cell_phone\": \"2288554455\",\r\n    \"date_created\": \"2022-09-15\",\r\n    \"email\": \"jlkj@hkjhk.com\",\r\n    \"is_active\": 1,\r\n    \"last_name\": \"PEREZ\",\r\n    \"name\": \"Juan\",\r\n    \"tax_id_number\": \"ggjjgg940603asdc14\"\r\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/exam/empleados")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.toString();
    }

    private String consultaServ4() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \r\n    \"birth_date\": \"1994-06-03\",\r\n    \"cell_phone\": \"2288554455\",\r\n    \"date_created\": \"2022-09-15\",\r\n    \"email\": \"jlkj@hkjhk.com\",\r\n    \"is_active\": 1,\r\n    \"last_name\": \"PEREZ\",\r\n    \"name\": \"Juan\",\r\n    \"tax_id_number\": \"fgjjgg940603asdc14\"\r\n}");
        Request request = new Request.Builder()
                .url("http://192.168.1.65:8080/exam/empleado/2")
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
    }

    private String consultaServ5() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://192.168.1.65:8080/exam/empleado/2/contrato/")
                .method("DELETE", body)
                .build();
        Response response = client.newCall(request).execute();
        return response.toString();
    }

}