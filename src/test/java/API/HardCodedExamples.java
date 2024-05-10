package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    //in rest assured base URI = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzIwNTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU3NTI1NywidXNlcklkIjoiNjEwNyJ9.t5Dnc0ddiHrxnP3PfO9HJDCaaYOGKa9PtPZWQ-xQVkY";
    static  String employee_id;
    @Test
    public void AcreateEmployee(){
        //prepare the request
        //request specification allows us to prepare the request And gives it in variable
        RequestSpecification request = given().
                header("Content-Type", "application/json")
                .header("Authorization", token).body("{\n" +
                "  \"emp_firstname\": \"Chinoso\",\n" +
                "  \"emp_lastname\": \"Nnadi\",\n" +
                "  \"emp_middle_name\": \"Modestus\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1991-05-11\",\n" +
                "  \"emp_status\": \"active\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}");
        //send the request for creating and adding the employee
        //Response is the class which holds the complete response body and the info
        Response response = request.when().post("/createEmployee.php");

        //To print the response in console
        response.prettyPrint();
        //validate the response
        response.then().assertThat().statusCode(201);

        //validate the body
        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Chinoso"));
        response.then().assertThat().
               header("Connection", equalTo("Keep-Alive"));
        //to store the employee id after generating the employee
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }
    @Test
    public void BgetCreatedEmployee() {
        //prepare the request
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).
                //employee_id goes from class var we created
                        queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        //validate the employee ids (one from post call, another from get call)
        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        Assert.assertEquals(tempEmpId, employee_id);

    }
    @Test
    public void CUpdateEmployee () {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Chidera\",\n" +
                        "  \"emp_lastname\": \"Ekezie\",\n" +
                        "  \"emp_middle_name\": \"Augusta\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1995-10-23\",\n" +
                        "  \"emp_status\": \"struggling\",\n" +
                        "  \"emp_job_title\": \"survivor\"\n" +
                        "}");
        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void DgetupdatedEmployee () {
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }
}
