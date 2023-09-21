package BaiTap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;

public class IPConnectivityChecker {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap3\\ip_list.txt"; 
        
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
            return address.isReachable(5000); // Thời gian chờ kết nối là 5 giây
        } catch (IOException e) {
            return false;
        }
    }
}