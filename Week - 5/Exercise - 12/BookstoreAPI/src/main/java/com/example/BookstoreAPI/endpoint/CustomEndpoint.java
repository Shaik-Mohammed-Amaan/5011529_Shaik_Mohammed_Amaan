package com.example.BookstoreAPI.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public String readOperation() {
        return "This is a custom endpoint!";
    }

    @WriteOperation
    public String updateOperation(String newValue) {
        return "Custom endpoint updated with value: " + newValue;
    }

    @DeleteOperation
    public String deleteOperation(){
        return "Delete operation performed";
    }
}
