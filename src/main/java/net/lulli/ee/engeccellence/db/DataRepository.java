package net.lulli.ee.engeccellence.db;

import net.lulli.ee.engeccellence.dto.Contract;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataRepository {
    ContractEntity saveContract(Contract contract);

    Optional<ContractEntity> getContractEntity(String contractId);

    void updateContractEntity(Contract contract);

    void deleteContractEntity(Contract contract);

    List<ContractEntity> findAllContracts();
}
