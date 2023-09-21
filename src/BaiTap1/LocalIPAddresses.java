package BaiTap1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalIPAddresses {
	public static void main(String[] args) {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			InetAddress[] allIPs = InetAddress.getAllByName(localhost.getHostName());
			System.out.println("Tất cả các địa chỉ  IP của máy tính hiện tại : ");
			for (InetAddress ip : allIPs) {
				System.out.println(ip.getHostAddress());
			}
		} catch (UnknownHostException e) {
			System.out.println("Lỗi: Không thể lấy thông tin địa chỉ IP. ");
		}
	}
}
