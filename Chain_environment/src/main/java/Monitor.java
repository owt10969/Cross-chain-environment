import java.math.BigInteger;
import java.util.Date;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

//import PSO_Algorithm_Try.Node;

public class Monitor {
	//Inital Contract
	public static Message_contract_sol_Message_contract ChainB_initialContract, ChainR_initialContract, ChainA_initialContract;
	
	//Declare node web3j
	static Web3j web8545,web8546,web8547,web8549,web8550,web8551,web2001,web2002,web2003;
	
	//Declare node credentials
	static Credentials Cre8545,Cre8546,Cre8547,Cre8549,Cre8550,Cre8551,Cre2001,Cre2002,Cre2003;
	
	//For timestamp
	static BigInteger Nextstamp,Currentstamp;
	
	public static void main(String[] args){
		long timeCount = StartCountTime();
		try {
			easy_test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Test Error");
			e.printStackTrace();
		}
		StopCountTime(" Easy_test in main function cost :  ", timeCount);
	}
	
	public static void easy_test() throws Exception{
		//Relay
		Initial_ChainPoA_node1();
		Get_blockInfo(web8545);
		System.out.println("=============================================================");
		
		//ChainB-Source Chain
		Initial_Chain1_node0();
		Get_blockInfo(web8549);
		System.out.println("=============================================================");
		
		//ChainA-Target Chain
		Initial_Chain2_node0();
		Get_blockInfo(web2001);
		System.out.println("=============================================================");
		
		//Initial Three Contract
		//ChainB
		InitialContract_Source(ChainB_initialContract,web8549,Cre8549);
		System.out.println("=============================================================");
		//ChainR
		InitialContract_Relay(ChainR_initialContract,web8545,Cre8545);
		System.out.println("=============================================================");
		//ChainA
		InitialContract_Target(ChainA_initialContract,web2001,Cre2001);
		System.out.println("=============================================================");
	}
	
	public static void Get_blockInfo(Web3j web3j) throws Exception{
			
			//Laststamp = Remstamp;
			
			//getBlockNumber();
			long timeCount = StartCountTime();
			
			EthBlockNumber result = web3j.ethBlockNumber().sendAsync().get();
			long blockNumber = result.getBlockNumber().longValue();
			System.out.println("Current blockNumber : " + result.getBlockNumber().toString());
			
			
			//getBlockInfo();
			
			EthBlock pendingEthBlock = web3j.ethGetBlockByNumber(DefaultBlockParameterName.PENDING,false).send();
			EthBlock latestEthBlock = web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, false).send();
			
			System.out.println("Blcok Number " + blockNumber +"'s Total difficulty : " + latestEthBlock.getBlock().getTotalDifficulty());
			
			System.out.println("Blcok Number " + blockNumber +"'s difficulty : " + latestEthBlock.getBlock().getDifficulty());
			
			System.out.println("Blcok Number " + blockNumber +"'s hash : " + latestEthBlock.getBlock().getHash());
			
			System.out.println("Blcok Number " + blockNumber +"'s timestamp : " + latestEthBlock.getBlock().getTimestamp());
			
			System.out.println("Pending Block : " + pendingEthBlock.getBlock().getTimestamp());
			
			System.out.println("Timestamp to datatime : " + TimestampToDate(latestEthBlock.getBlock().getTimestamp()));
			
			System.out.println("LatestEthBlock Difficulty : " + latestEthBlock.getBlock().getDifficulty());
			
			System.out.println("Now Total Difficulty : " + latestEthBlock.getBlock().getTotalDifficulty());
			
			Nextstamp= pendingEthBlock.getBlock().getTimestamp();
			Currentstamp = latestEthBlock.getBlock().getTimestamp();
			System.out.println(TimestampDiff(Currentstamp,Nextstamp));
			
			StopCountTime("Get Node Info Cost : " , timeCount);
			
		}
		
	/*Chain PoA*/
	public static void Initial_ChainPoA_node1() throws Exception {
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Ethereum_PoA\\node\\keystore";
		String walletName = "UTC--2021-05-20T06-04-00.812610300Z--15be92c798cf6dbac416b4b707afd2a7e9180022";
		//Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8545"));
		web8545 = Web3j.build(new HttpService("http://127.0.0.1:8545"));
		
		
		
		//Credentials credentials = WalletUtils.loadCredentials("123456", path_to_walletfile);
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/" + walletName);
		Cre8545 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/" + walletName);
		System.out.println(" PoA_Node1_Credentials : " + Cre8545);
		
		
		StopCountTime("Initial_ChainPoA_node1: " , TimeCount);
		
		}
	public static void Initial_ChainPoA_node2() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Ethereum_PoA\\node2\\keystore";
		String walletName = "UTC--2021-05-24T09-50-56.533081800Z--e607e379427919b282f9cc53a266f1f01350c75f";
		web8546 = Web3j.build(new HttpService("http://127.0.0.1:8546"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletName, walletDirectory+"/"+ walletName);
		Cre8546 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/" + walletName);
		System.out.println(" PoA_Node2_Credentials : " + Cre8546);
		
		StopCountTime("Initial_ChainPoA_node2 : " , TimeCount);
		
	}
	public static void Initial_ChainPoA_node3() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Ethereum_PoA\\node3\\keystore";
		String walletName = "UTC--2021-05-20T06-36-52.812361000Z--f588080b5e1a3be68381693a767f298135baf198";
		web8547 = Web3j.build(new HttpService("http://127.0.0.1:8547"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		Cre8547 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		System.out.println("PoA_Node3_Credentials : " + Cre8547);
		
		StopCountTime("Initial_ChainPoA_node3 : " ,TimeCount);
	}
	
	/*Chain Chain1*/
	public static void Initial_Chain1_node0() throws Exception{
		long TimeCount =StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain1\\node0\\keystore";
		String walletName = "UTC--2022-10-01T13-28-44.727747600Z--1f941a6d7880bf5dc6f1a4cf9c50ec5f5a0392e8";
		//Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8549"));
		web8549 = Web3j.build(new HttpService("http://127.0.0.1:8549"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		Cre8549 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		System.out.println(" Ethereum1_Node0_Credentials : " + Cre8549);
		
		StopCountTime("Initial_Chain1_node : " , TimeCount);
	
	}
	public static void Initial_Chain1_node1() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword ="123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain1\\node1\\keystore";
		String walletName = "UTC--2022-10-01T13-29-16.255134900Z--84874fb22a968f5a686885e47a0ec28576c9f338";
		web8550 = Web3j.build(new HttpService("http://127.0.0.1:8550"));
	
		//Build Crendentials
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		Cre8550 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		System.out.println(" Ethereum1_Node1_Credentials : " + Cre8550);
		
		StopCountTime("Initial_Chain1_node1: " , TimeCount);
		
	}
	public static void Initial_Chain1_node2() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain1\\node2\\keystore";
		String walletName = "UTC--2022-10-01T13-29-36.316107100Z--21c599f87c497fbb7e24e4977db5a8bd407e2747";
		web8551 = Web3j.build(new HttpService("http://127.0.0.1:8551"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword,walletDirectory+"/"+walletName);
		Cre8551 = WalletUtils.loadCredentials(walletPassword,walletDirectory+"/"+walletName);
		
		System.out.println(" Ethereum1_Node2_Credentials : " + Cre8551);
		
		StopCountTime("Initial_Ethereum1_node2 : " , TimeCount);
		
	
	}
	
	/*Chain Chain2*/
	public static void Initial_Chain2_node0() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain2\\node0\\keystore";
		String walletName = "UTC--2022-10-01T13-16-58.222596600Z--fc13ce27228079504fda2a2b85ac56033ba792c9";
		web2001 = Web3j.build(new HttpService("http://127.0.0.1:2001"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		Cre2001 = WalletUtils.loadCredentials(walletPassword,walletDirectory+"/"+walletName);
		System.out.println("Ethereum2_node0_Credentials : " + Cre2001);
		
		StopCountTime("Initial_Chain2_node0 : " , TimeCount);
	}
	public static void Initial_Chain2_node1() throws Exception{
		long TimeCount = StartCountTime();
		
		String walletPassword = "123456";
		String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain2\\node1\\keystore";
		String walletName = "UTC--2022-10-01T13-17-14.371799600Z--e2aff164376722f8b7e79b98a2da919b94eac87b";
		web2002 = Web3j.build(new HttpService("http://127.0.0.1:2002"));
		
		//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		Cre2002 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
		
		System.out.println(" Ethereum2_node1_Credentials : " + Cre2002);
		
		StopCountTime("Initial_Chain2_node1: " ,TimeCount);
	}
	public static void Initial_Chain2_node2() throws Exception{
			long TimeCount = StartCountTime();
			
			String walletPassword = "123456";
			String walletDirectory = "C:\\WorkSpace\\method\\Reputation_Chain\\Chain2\\node2\\keystore";
			String walletName = "UTC--2022-10-01T13-18-40.950052100Z--b6bbe94b040773aac0e4823d80b64e5804ded554";
			web2003 = Web3j.build(new HttpService("http://127.0.0.1:2003"));
			
			//Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
			Cre2003 = WalletUtils.loadCredentials(walletPassword, walletDirectory+"/"+walletName);
			System.out.println(" Ethereum2_node2_Credentials : " + Cre2003);
			
			StopCountTime("Initial_Ethereum2_node2 : " ,TimeCount);
		}
	

	public static void InitialContract_Relay(Message_contract_sol_Message_contract contract, Web3j Source_web3j, Credentials Source_credentials) throws Exception{
		
		long timeCount = StartCountTime();
		
		//ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
		ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(200000L), BigInteger.valueOf(672190L));
		//Message_contract_sol_Message_contract contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		//contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		ChainR_initialContract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		//String contractAddress = contract.getContractAddress();
		
		String contractAddress = ChainR_initialContract.getContractAddress();
		
		System.out.println("Initial Contract Address : " + contractAddress);
		
		//contract.set_Message(set_Message);
		
		//System.out.println("Source_node set message : " + ChainR_initialContract.get_Message() + " Setting Complete.");
		
		StopCountTime("Initila"+Source_web3j.toString()+"Contract Cost : ", timeCount);
		
	}
	
	public static void InitialContract_Source(Message_contract_sol_Message_contract contract, Web3j Source_web3j, Credentials Source_credentials) throws Exception{
		
		long timeCount = StartCountTime();
		
		//ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
		ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(200000L), BigInteger.valueOf(672190L));
		//Message_contract_sol_Message_contract contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		//contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		ChainB_initialContract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		
		//String contractAddress = contract.getContractAddress();
		
		String contractAddress = ChainB_initialContract.getContractAddress();
		
		System.out.println("Initial Contract Address : " + contractAddress);
		
		//contract.set_Message(set_Message);
		
		//System.out.println("Source_node set message : " + contract.get_Message() + " Setting Complete.");
		
		StopCountTime("Initila"+Source_web3j.toString()+"Contract Cost : ", timeCount);
	}
	
	public static void InitialContract_Target(Message_contract_sol_Message_contract contract, Web3j Source_web3j, Credentials Source_credentials) throws Exception{
		
		long timeCount = StartCountTime();
		
		//ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
		ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(200000L), BigInteger.valueOf(672190L));
		//Message_contract_sol_Message_contract contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		//contract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		ChainA_initialContract = Message_contract_sol_Message_contract.deploy(Source_web3j, Source_credentials, provider).send();
		
		//String contractAddress = contract.getContractAddress();
		
		String contractAddress = ChainA_initialContract.getContractAddress();
		
		System.out.println("Initial Contract Address : " + contractAddress);
		
		//contract.set_Message(set_Message);
		
		//System.out.println("Source_node set message : " + contract.get_Message() + " Setting Complete.");
		
		StopCountTime("Initila"+Source_web3j.toString()+"Contract Cost : ", timeCount);
	}	
		
		
	/*Tool*/
	public static long StartCountTime() {
		  long time1;
	      time1 = System.currentTimeMillis();
	
	      
	      return time1;
	  }
	public static void StopCountTime(String Info,long time1) {
		  long time2;
		  time2 = System.currentTimeMillis();
		  System.out.println(Info +" : "  + (time2-time1) + " ms");
	  }
	public static Date TimestampToDate(BigInteger timestamp) {
		/*Timestamp to Date*/
	
		/*轉換型態*/
		long millis = timestamp.longValue();
		Date date = new Date(millis*1000);
		return date;
	}
	public static String TimestampDiff(BigInteger LastStamp, BigInteger CurrentStamp) {
		Long diff = CurrentStamp.longValue() - LastStamp.longValue();
		
		String re = "與下一個區塊相差: " + diff.toString() +"秒";
		return re;
	}
	public static void print (double[] a) {
		System.out.println("Best solution for each problem : ");
		System.out.print("< ");
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]  + " ");
		}
		System.out.println(" > ");

	}

}
