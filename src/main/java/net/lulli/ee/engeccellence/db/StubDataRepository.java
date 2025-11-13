package net.lulli.ee.engeccellence.db;

import net.lulli.ee.engeccellence.dto.Contract;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
    This class fakes a database by providing in-memory the same CRUD operations
    as a real Repository pattern for data store in a Database
 */
public class StubDataRepository implements DataRepository {

    private static final List<ContractEntity> stubDataStore = new ArrayList<>();
    public static final ZoneOffset DEFAULT_APP_TIME_ZONE = ZoneOffset.UTC;

    public List<ContractEntity> findAllContracts() {
        return stubDataStore;
    }

    public ContractEntity saveContract(Contract contract) {
        var entity = new ContractEntity();
        entity.setContractId(contract.getId());
        entity.setContractName(contract.getName());
        entity.setCreatedOn(Instant.now().toEpochMilli());
        entity.setContractName(contract.getName());
        entity.setContractType(contract.getType());
        stubDataStore.add(entity);
        return entity;
    }

    public Optional<ContractEntity> getContractEntity(String contractId) {
        System.out.println("stubDataStore.size() :" + stubDataStore.size());
        for (ContractEntity entity : stubDataStore) {
            if (entity.getContractId().equals(contractId)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    public void updateContractEntity(Contract contract) {
        getContractEntity(contract.getId()).ifPresent(entity -> {
            entity.setContractName(contract.getName());
            entity.setContractId(contract.getId());
            entity.setCreatedOn(contract.getCreatedOn().toInstant(DEFAULT_APP_TIME_ZONE).toEpochMilli());
        });
    }

    public void deleteContractEntity(Contract contract) {
        getContractEntity(contract.getId()).ifPresent(entity -> {
            stubDataStore.remove(entity);
        });
    }
}
