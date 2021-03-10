package n.sokhin.simplenums.controller;

import n.sokhin.simplenums.service.SimpleNumsComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@RestController
public class SimpleNumRestController {

    @Autowired
    SimpleNumsComputeService compute;

    @RequestMapping(value = "/simplenums", method = RequestMethod.POST)
    public HashMap<BigInteger, Integer> checkSimpleNums(@RequestParam List<BigInteger> bigIntList){

        return compute.getDuplicates(bigIntList);
    }
}
