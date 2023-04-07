

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.contracts.*;
import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
//import org.web3j.abi.TypeReference;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Message_contract_sol_Message_contract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061043f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c806304bfb4a714610067578063396c7be01461007c5780636034a6fb14610092578063ae4c8e21146100a5578063b25a781f146100ba578063de455a4d146100cd575b600080fd5b61007a6100753660046101a8565b6100d5565b005b6002546040519081526020015b60405180910390f35b61007a6100a03660046101a8565b6100e5565b6100ad6100f1565b6040516100899190610259565b61007a6100c83660046102a7565b600255565b6100ad610183565b60016100e18282610349565b5050565b60006100e18282610349565b606060018054610100906102c0565b80601f016020809104026020016040519081016040528092919081815260200182805461012c906102c0565b80156101795780601f1061014e57610100808354040283529160200191610179565b820191906000526020600020905b81548152906001019060200180831161015c57829003601f168201915b5050505050905090565b606060008054610100906102c0565b634e487b7160e01b600052604160045260246000fd5b6000602082840312156101ba57600080fd5b813567ffffffffffffffff808211156101d257600080fd5b818401915084601f8301126101e657600080fd5b8135818111156101f8576101f8610192565b604051601f8201601f19908116603f0116810190838211818310171561022057610220610192565b8160405282815287602084870101111561023957600080fd5b826020860160208301376000928101602001929092525095945050505050565b600060208083528351808285015260005b818110156102865785810183015185820160400152820161026a565b506000604082860101526040601f19601f8301168501019250505092915050565b6000602082840312156102b957600080fd5b5035919050565b600181811c908216806102d457607f821691505b6020821081036102f457634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561034457600081815260208120601f850160051c810160208610156103215750805b601f850160051c820191505b818110156103405782815560010161032d565b5050505b505050565b815167ffffffffffffffff81111561036357610363610192565b6103778161037184546102c0565b846102fa565b602080601f8311600181146103ac57600084156103945750858301515b600019600386901b1c1916600185901b178555610340565b600085815260208120601f198616915b828110156103db578886015182559484019460019091019084016103bc565b50858210156103f95787850151600019600388901b60f8161c191681555b5050505050600190811b0190555056fea26469706673582212207dcc4930a1f6ec596469f67e92e7e231830fe40e8d272e2b91783a401061032c64736f6c63430008110033";

    public static final String FUNC_GET_MESSAGE = "get_Message";

    public static final String FUNC_GET_REPUTATION = "get_reputation";

    public static final String FUNC_GET_TRANSACTION_STATE = "get_transaction_state";

    public static final String FUNC_SET_MESSAGE = "set_Message";

    public static final String FUNC_SET_REPUTATION = "set_reputation";

    public static final String FUNC_SET_TRANSACTION_STATE = "set_transaction_state";

    @Deprecated
    protected Message_contract_sol_Message_contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Message_contract_sol_Message_contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Message_contract_sol_Message_contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Message_contract_sol_Message_contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> get_Message() {
        final Function function = new Function(FUNC_GET_MESSAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> get_reputation() {
        final Function function = new Function(FUNC_GET_REPUTATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> get_transaction_state() {
        final Function function = new Function(FUNC_GET_TRANSACTION_STATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> set_Message(String _message) {
        final Function function = new Function(
                FUNC_SET_MESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_message)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> set_reputation(BigInteger _reputation) {
        final Function function = new Function(
                FUNC_SET_REPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_reputation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> set_transaction_state(String _state) {
        final Function function = new Function(
                FUNC_SET_TRANSACTION_STATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_state)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Message_contract_sol_Message_contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Message_contract_sol_Message_contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Message_contract_sol_Message_contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Message_contract_sol_Message_contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Message_contract_sol_Message_contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Message_contract_sol_Message_contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Message_contract_sol_Message_contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Message_contract_sol_Message_contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Message_contract_sol_Message_contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Message_contract_sol_Message_contract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Message_contract_sol_Message_contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Message_contract_sol_Message_contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Message_contract_sol_Message_contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Message_contract_sol_Message_contract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Message_contract_sol_Message_contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Message_contract_sol_Message_contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
