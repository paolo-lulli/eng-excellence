package net.lulli.ee.engeccellence.db;

import java.util.Objects;

public class ContractEntity {
    private String contractId;
    private String contractName;
    private String contractType;
    private long createdOn;

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContractEntity that = (ContractEntity) o;
        return createdOn == that.createdOn && Objects.equals(contractId, that.contractId) && Objects.equals(contractName, that.contractName) && Objects.equals(contractType, that.contractType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, contractName, contractType, createdOn);
    }

    @Override
    public String toString() {
        return "ContractEntity{" +
                "contractId='" + contractId + '\'' +
                ", contractName='" + contractName + '\'' +
                ", contractType='" + contractType + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
