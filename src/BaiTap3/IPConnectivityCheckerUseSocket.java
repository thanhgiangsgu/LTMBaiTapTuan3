package BaiTap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class IPConnectivityCheckerUseSocket {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap3\\ip_list.txt"; // Tên file chứa danh sách địa chỉ IP
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isIPReachable(line)) {
                    System.out.println(line + " - Kết nối được.");
                } else {
                    System.out.println(line + " - Không kết nối được.");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc file " + fileName);
        }
    }

    private static boolean isIPReachable(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            int timeout = 5000; // Thời gian chờ kết nối (5 giây)
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(address, 80), timeout);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}