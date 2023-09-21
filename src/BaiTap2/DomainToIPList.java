package BaiTap2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainToIPList {
	public static void main(String[]  args) {
		String fileName = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap2\\domain_list.txt";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					InetAddress  address = InetAddress.getByName(line);
					String ip = address.getHostAddress();
					System.out.println("Domain: " + line + " - IP: " + ip);
				} catch (UnknownHostException  e) {
					System.out.println("Lỗi: Không thể phân giải tên miền " + line);
				}
			}
		} catch (IOException e) {
			System.out.println("Lỗi: Không thể đọc file " + fileName);
		}
	}
}
