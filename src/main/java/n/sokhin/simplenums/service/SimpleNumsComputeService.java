package n.sokhin.simplenums.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;


public interface SimpleNumsComputeService {
    HashMap<BigInteger, Integer> getDuplicates(List<BigInteger> bigDecimals);
}
