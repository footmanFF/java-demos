package com.fm.rpc;

/**
 * Created by fm on 2017/3/31.
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }

}