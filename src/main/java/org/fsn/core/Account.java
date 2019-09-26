package org.fsn.core;

import org.fsn.crypto.ECKey;
import org.spongycastle.util.encoders.Hex;

public class Account {

    private ECKey ecKey;

    private  byte[] pubKeyHash ;

    public Account (ECKey ecKey){
        this.ecKey =ecKey;
    }

    public void createAccountFromPrivate(byte[] privKeyBytes){
        this.ecKey = ECKey.fromPrivate(privKeyBytes);
        this.pubKeyHash = ecKey.getAddress();
    }

    public void createAccountFromPublicOnly(byte[] pubKeyBytes){
        this.ecKey = ECKey.fromPublicOnly(pubKeyBytes);
        this.pubKeyHash = ecKey.getAddress();
    }

    public String getAddress(){
        if (pubKeyHash == null ){
            this.ecKey = new ECKey();
            this.pubKeyHash = ecKey.getAddress();
        }
        return  "0x" + Hex.toHexString(this.pubKeyHash);
    }


}
