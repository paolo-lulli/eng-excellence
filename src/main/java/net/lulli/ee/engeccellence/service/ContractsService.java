package net.lulli.ee.engeccellence.service;

import net.lulli.ee.engeccellence.dto.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractsService.class);

    private List<Contract> contractList = new ArrayList<>();

    public List<Contract> getAllContracts() {
        return contractList;
    }

    public Optional<Contract> getContract(String id) {
        for (Contract contract : contractList) {
            if (contract.getId() == id) {
                LOGGER.info("Retrieved contract id: {}", contract.getId());
                return Optional.of(contract);
            }
        }
        LOGGER.error("Could not retrieve contract with id: {}", id);
        return Optional.empty();
    }

    public void addContract(Contract contract) {
        contractList.add(contract);
        LOGGER.info("Added contract {}", contract);
    }

    public void updateContract(String id, Contract updatedContract) {
        for (Contract contract : contractList) {
            if (contract.getId() == id) {
                contract.setName(updatedContract.getName());
                LOGGER.info("Updated contract {}", contract);
            }
        }
        LOGGER.error("Could not find contract to update");

    }

    public void deleteContract(String id) {
        var removed = contractList.removeIf(contract -> contract.getId().equals(id));
        if (removed) {
            LOGGER.info("Removed contract {}", id);
        } else {
            LOGGER.error("Could not find contract to remove with id: {}", id);
        }

    }
}
