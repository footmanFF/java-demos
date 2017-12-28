package com.fm.net;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * @author zhangli on 2017/8/26.
 */
public class BaseTest {

    @Test
    public void test() {
        Socket socket = null;
        try {
            socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ASCII");
            StringBuilder time = new StringBuilder();
            for (int c = inputStreamReader.read(); c != -1; c = inputStreamReader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        Socket socket = null;
        try {
            socket = new Socket("dict.org", 2628);
            socket.setSoTimeout(15000);
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write("DEFINE eng-lat gold\r\n");
            writer.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null && !line.equals(".")) {
                System.out.println(line);
            }

            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        Socket socket = null;
        try {
            // 构造方法内会启动与远程主机的连接
            socket = new Socket("dict.org", 2628);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        Socket socket = null;
        for (int i = 0; i < 1024; i++) {
            try {
                socket = new Socket("localhost", i);
                System.out.println("port " + i + " server");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // ignore
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void test5() {
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            Socket socket = new Socket("www.baidu.com", 80, inetAddress, 0);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        Socket socket = new Socket();
        InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 80);

        try {
            socket.connect(socketAddress);
            // socket.connect(socketAddress, 1000);
            System.out.println(socket.getLocalAddress());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test7() {
        SocketAddress proxyAddress = new InetSocketAddress("somedomain", 100);
        Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
        Socket socket = new Socket();
        InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 80);
        try {
            socket.connect(socketAddress);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}