package BaiTap4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkDeviceScanner {
    public static void main(String[] args) {
        String localIPAddress = "192.168.1.10"; // Địa chỉ IP của máy tính của bạn
        String networkPrefix = localIPAddress.substring(0, localIPAddress.lastIndexOf(".") + 1);
        
        System.out.println("Các thiết bị mạng đang online trong mạng con " + networkPrefix + "x:");
        
        for (int i = 1; i <= 255; i++) {
            String ipAddressToCheck = networkPrefix + i;
            if (isIPReachable(ipAddressToCheck)) {
                System.out.println(ipAddressToCheck + " - Thiết bị online");
            }
        }
    }

    private static boolean isIPReachable(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            return address.isReachable(5000); // Thời gian chờ kết nối là 5 giây
        } catch (UnknownHostException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}