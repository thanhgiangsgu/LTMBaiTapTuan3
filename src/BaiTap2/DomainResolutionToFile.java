package BaiTap2;

// Bài tập này giúp phân loại các domain name 
// Các domain name phân giải được thì sẽ chuyển vào tệp "resolved_domains.txt"
//Các domain name không phân giải được thì sẽ chuyển vào tệp "unresolved_domains.txt"

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainResolutionToFile {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap2\\domain_list.txt";
        String resolvedFile = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap2\\resolved_domains.txt";
        String unresolvedFile = "C:\\Users\\thanh\\LTM\\BaiTapTuan3\\src\\BaiTap2\\unresolved_domains.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter resolvedWriter = new BufferedWriter(new FileWriter(resolvedFile));
             BufferedWriter unresolvedWriter = new BufferedWriter(new FileWriter(unresolvedFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    InetAddress address = InetAddress.getByName(line);
                    String ip = address.getHostAddress();
                    resolvedWriter.write(line + " - " + ip + "\n");
                } catch (UnknownHostException e) {
                    unresolvedWriter.write(line + "\n");
                }
            }

            System.out.println("Phân giải hoàn thành. Kết quả đã được ghi vào " + resolvedFile + " và " + unresolvedFile);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể đọc/ghi file.");
        }
    }
}
