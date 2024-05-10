package Util;

import APISteps.APIWorkFlowSteps;
import org.json.JSONObject;

public class APIPayloadConstants {

    public static String generateTokenPayload(){
        String generateToken = "{\n" +
                "    \"email\": \"nnadi@batch17.com\",\n" +
                "    \"password\": \"Test@123\"\n" +
                "}";
        return generateToken;
    }

    public static String createEmployeePayload(){
        String createEmployee = "{\n" +
                "  \"emp_firstname\": \"Chinoso\",\n" +
                "  \"emp_lastname\": \"Nnadi\",\n" +
                "  \"emp_middle_name\": \"Modestus\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1991-05-11\",\n" +
                "  \"emp_status\": \"active\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
        return createEmployee;
    }

    public static String createEmployeeJsonPayload(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Chinoso");
        obj.put("emp_lastname", "Nnadi");
        obj.put("emp_middle_name", "Modestus");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1991-05-11");
        obj.put("emp_status", "active");
        obj.put("emp_job_title", "QA");

        return obj.toString();
    }
    public static String payloadDynamic(String emp_firstName,String emp_lastname,
                                        String emp_middle_name,String emp_gender,
                                        String emp_birthday,String emp_status,
                                        String emp_job_title
    ){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstName);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);

        return obj.toString();
    }
    public static String updateEmployeePayload(){
        JSONObject obj = new JSONObject();
        //obj.put("employee_id", APIWorkFlowSteps.employee_id);

        obj.put("employee_id", "96675A");
        obj.put("emp_firstname", "Evan");
        obj.put("emp_lastname", "Caesar");
        obj.put("emp_middle_name", "Chigozie");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1998-05-11");
        obj.put("emp_status", "not active");
        obj.put("emp_job_title", "Software Tester");

        return obj.toString();
    }
}
