# Cross-chain-environment
Contain three private-chain which build with .puppeth. You can easily demo the cross-chain interaction with DApp and Smart-Contract.


### The enviornment of each chain.

## You can run startnode.cmd in package Chain1, Chain2, Ethereum_PoA for implement nodes easily.

```
[
  {
    "name":Chain-1,
    "Consensus": PoW,
    "Network ID": "10"
    "RPC-port": "2001, 2002, 2003"
    "Port": "30013, 30014, 30015"
  },
  {
    "name":Chain-2,
    "Consensus": PoW,
    "Network ID": "11"
    "RPC-port": "8545, 8546, 8547"
    "Port": "30306, 30307, 30308"
  },
  {
    "name":Ethereum_PoA,
    "Consensus": PoA,
    "Network ID": "1883"
    "RPC-port": "8545, 8546, 8547"
    "Port": "30306, 30307, 30308"
  }
  
]
```


## Implement Enviornment

* Windows 10 64Bit
* Ethereum
* Go 1.16.3 
* Solidity 0.4.21
* Remix IDE
* Web3.js
* Oracle Java 17
* Eclipse 3.8 with Open JDK 
* Geth 1.9.25 with puppeth

