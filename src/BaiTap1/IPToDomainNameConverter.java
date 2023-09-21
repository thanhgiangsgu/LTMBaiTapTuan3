package BaiTap1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

// Viết một chương trình Java để nhập một địa chỉ IP từ người dùng và sau đó in ra tên miền tương ứng của địa chỉ IP đó (nếu có).

public class IPToDomainNameConverter {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("Nhập địa chỉ IP:  ");
		String ipAddress = scanner.nextLine();
		
		try {
			InetAddress address = InetAddress.getByName(ipAddress);
			String domainName = address.getHostName();
			System.out.println("Tên miền tương ứng : " + domainName);
		} catch (UnknownHostException e) {
			System.out.println("Lỗi : Không thể phân giải địa chỉ IP. ");
		}
		scanner.close();
	}
}
