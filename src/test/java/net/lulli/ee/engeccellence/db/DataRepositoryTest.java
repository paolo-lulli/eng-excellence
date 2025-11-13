package net.lulli.ee.engeccellence.db;

import net.lulli.ee.engeccellence.dto.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

public class DataRepositoryTest {

    static Contract buildContract() {
        var contract = new Contract();
        contract.setId(UUID.randomUUID().toString());
        contract.setCreatedOn(LocalDateTime.now());
        contract.setType("SomeType");
        contract.setName(UUID.randomUUID().toString());

        return contract;
    }

    static Contract buildContractWithId(String id) {
        var contract = new Contract();
        contract.setId(id);
        contract.setCreatedOn(LocalDateTime.now());
        contract.setType("SomeType");
        contract.setName(UUID.randomUUID().toString());

        return contract;
    }


    @Test
    public void testCreateContractEntity() {
        var dataRepo = new StubDataRepository();

        var initialContractN = dataRepo.findAllContracts().size();
        dataRepo.saveContract(buildContract());

        var storedContractN = dataRepo.findAllContracts().size() - initialContractN;
        Assertions.assertEquals(storedContractN, 1);
    }

    @Test
    public void testDumpDb() {
        var dataRepo = new StubDataRepository();

        dataRepo.saveContract(buildContract());
        dataRepo.saveContract(buildContract());
        dataRepo.saveContract(buildContract());

        for (var contract : dataRepo.findAllContracts()) {
            System.out.println(contract.toString());
        }
    }

    @Test
    public void testGetContractEntity() {
        var dataRepo = new StubDataRepository();

        var initialContractN = dataRepo.findAllContracts().size();
        var contract = buildContract();
        dataRepo.saveContract(contract);

        var storedContractN = dataRepo.findAllContracts().size() - initialContractN;
        Assertions.assertEquals(storedContractN, 1);

        dataRepo.deleteContractEntity(contract);

        Assertions.assertFalse(dataRepo.getContractEntity(contract.getId()).isPresent());

    }


    static Contract remapContract(ContractEntity entity) {
        var contract = new Contract();
        contract.setId(entity.getContractId());
        contract.setName(entity.getContractName());
        contract.setCreatedOn(LocalDateTime.ofInstant(Instant.ofEpochMilli(entity.getCreatedOn()), ZoneId.systemDefault()));
        contract.setType(entity.getContractType());
        return contract;
    }

    @Test
    public void testDeleteContractEntity() {
        var dataRepo = new StubDataRepository();

        var initialContractN = dataRepo.findAllContracts().size();
        dataRepo.saveContract(buildContract());
        dataRepo.saveContract(buildContract());
        dataRepo.saveContract(buildContract());

        var storedContractN = dataRepo.findAllContracts().size() - initialContractN;
        Assertions.assertEquals(storedContractN, 3);
    }

    @Test
    public void testUpdateContractEntity() {
        var dataRepo = new StubDataRepository();

        var contract = buildContractWithId(UUID.randomUUID().toString());
        dataRepo.saveContract(contract);

        Optional<ContractEntity> contractEntity = dataRepo.getContractEntity(contract.getId());
        var modifiedContract = contractEntity.get();
        modifiedContract.setContractName("updated");

        var modifiedEntity = remapContract(modifiedContract);

        dataRepo.saveContract(modifiedEntity);
        var contractName = dataRepo.getContractEntity(contract.getId()).get().getContractName();

        Assertions.assertEquals("updated", contractName);

    }
}
