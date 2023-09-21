package BaiTap1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Bai1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Nhập tên miền ( hoặc nhập 'exit' để thoát : )");
			String input = scanner.nextLine();
			
			if (input.equalsIgnoreCase("exit")){
				System.out.println("Chương trình kết thúc");
				break;
			}
			
			try {
				InetAddress address = InetAddress.getByName(input);
				String ip = address.getHostAddress();
				System.out.println("IP tương ứng với " + input + " là: " + ip);
			} catch (UnknownHostException e) {
				System.out.println("Lỗi: Không thể phân giải tên miền " + input);
			}
		}
		scanner.close();
	}

}
