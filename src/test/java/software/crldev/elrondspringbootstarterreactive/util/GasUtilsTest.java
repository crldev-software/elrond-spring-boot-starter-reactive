package software.crldev.elrondspringbootstarterreactive.util;

import org.junit.jupiter.api.Test;
import software.crldev.elrondspringbootstarterreactive.domain.transaction.PayloadData;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GasUtilsTest {

    @Test
    void computeGasCost() {
        var expectedCost = BigInteger.valueOf(92500);
        assertEquals(expectedCost, GasUtils.computeGasCost(PayloadData.fromString("crldev x elrond")));

        var expectedCostEmpty = BigInteger.valueOf(70000);
        assertEquals(expectedCostEmpty, GasUtils.computeGasCost(PayloadData.empty()));
    }

}