package net.lulli.ee.engeccellence.service;

import net.lulli.ee.engeccellence.dto.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
public class ContractsServiceTest {

    @Autowired
    private ContractsService contractsService;

    @Test
    void testGetAllContracts() {
        Assertions.assertEquals(0, contractsService.getAllContracts().size());

        contractsService.addContract(buildContract());
        contractsService.addContract(buildContract());
        contractsService.addContract(buildContract());
        Assertions.assertEquals(3, contractsService.getAllContracts().size());
    }

    @Test
    void testAddContract() {
        int size = contractsService.getAllContracts().size();
        contractsService.addContract(buildContract());
        Assertions.assertEquals(1 + size, contractsService.getAllContracts().size());
    }

    @Test
    void testUpdateContract() {
        var contract = buildContract();
        var idContract = contract.getId();

        contractsService.addContract(contract);
        contract.setName("New name");
        contractsService.updateContract(idContract, contract);

        var retrievedContract = contractsService.getContract(idContract);
        Assertions.assertTrue(retrievedContract.isPresent());
        Assertions.assertEquals("New name", retrievedContract.get().getName());
    }

    @Test
    void testDeleteContracts() {
        contractsService.getAllContracts().forEach(contract -> {
        });
    }

    static Contract buildContract() {
        var contract = new Contract();
        contract.setId(UUID.randomUUID().toString());
        contract.setCreatedOn(LocalDateTime.now());
        contract.setType("SomeType");
        contract.setName(UUID.randomUUID().toString());

        return contract;
    }
}
