package n.sokhin.simplenums.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Service
public class SimpleNumsComputeServiceImpl implements SimpleNumsComputeService {
    @Override
    public HashMap<BigInteger, Integer> getDuplicates(List<BigInteger> bigDecimals) {

        HashMap<BigInteger, Integer> hashMap = new HashMap<>();

        for (BigInteger bd : bigDecimals) {
            if (checkSimple(bd)) {
                if (hashMap.containsKey(bd)) hashMap.computeIfPresent(bd, (key, val) -> (++val));
                else hashMap.put(bd, 1);
            }
        }
        return hashMap;
    }

    public boolean checkSimple(BigInteger i) {
        final BigInteger BI0 = BigInteger.ZERO;
        final BigInteger BI2 = new BigInteger("2");
        final BigInteger BI3 = new BigInteger("3");
        final BigInteger BI6 = new BigInteger("6");
        BigInteger[] a = i.divideAndRemainder(BI2);
        BigInteger[] b = i.divideAndRemainder(BI3);
        BigInteger n = new BigInteger("5");

        if (i.compareTo(BigInteger.ONE) == -1 || i.compareTo(BigInteger.ONE) == 0) {
            return false;
        } else if (i.compareTo(BI3) == -1 || i.compareTo(BI3) == 0) {
            return true;
        } else if (a[1].compareTo(BI0) == 0 || b[1].compareTo(BI0) == 0) {
            return false;
        }

        while ((n.multiply(n)).compareTo(i) == -1 || (n.multiply(n)).compareTo(i) == 0) {
            if ((i.divide(n)).compareTo(BI0) == 0 || i.divide(n.add(BI2)).compareTo(BI0) == 0) return false;
            n = n.add(BI6);
        }
        return true;
    }
}
