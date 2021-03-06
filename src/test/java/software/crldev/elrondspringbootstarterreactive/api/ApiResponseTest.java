package software.crldev.elrondspringbootstarterreactive.api;

import org.junit.jupiter.api.Test;
import software.crldev.elrondspringbootstarterreactive.error.ErrorMessage;
import software.crldev.elrondspringbootstarterreactive.error.exception.ResponseException;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void throwIfError() {
        var apiResponse = new ApiResponse<>();
        var expectedErrMsg = "failed for some reason";
        apiResponse.setError(expectedErrMsg);

        var ex = assertThrows(ResponseException.class, apiResponse::throwIfError);
        assertEquals(expectedErrMsg, ex.getMessage());

        apiResponse.setError("");
        apiResponse.setCode("notSuccessful");

        var ex2 = assertThrows(ResponseException.class, apiResponse::throwIfError);
        assertEquals(ErrorMessage.RESPONSE_NOT_SUCCESSFUL.getValue(), ex2.getMessage());
    }
}