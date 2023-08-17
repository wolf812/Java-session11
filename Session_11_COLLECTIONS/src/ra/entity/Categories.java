package ra.entity;

import com.sun.org.apache.xml.internal.dtm.ref.EmptyIterator;
import ra.IShop;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categories implements IShop<Categories> {
    private int catalogId;
    private String catalogName;
    private boolean Status;

    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, Boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        Status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }


    @Override
    public void inputData(Scanner sc, List<Categories> list) {
        System.out.println("Nhập mã danh mục:");
        boolean checkIdExit = true;

        do {
            boolean checkCatalogId = false;
            int catalogId = Integer.parseInt(sc.nextLine());
            for (Categories element :
                    list) {
                if (element.getCatalogId() == catalogId) {
                    System.err.println("Mã danh mục đã tồn tại");
                    checkCatalogId = true;
                }
            }
            if (!checkCatalogId) {
                this.catalogId = catalogId;
                checkIdExit = false;
            }

        } while (checkIdExit);


        System.out.println("Nhập tên danh mục:");
        boolean checkNameExit = true;

        do {
            boolean checkCatalogNameExit = false;
            String catalogName = sc.nextLine();
            for (Categories element :
                    list) {
                if (element.getCatalogName().equalsIgnoreCase(catalogName)) {
                    System.err.println("Tên danh mục đã tồn tại.");
                    checkCatalogNameExit = true;
                    break;
                }
            }
            if (!checkCatalogNameExit) {
                this.catalogName = catalogName;
                checkNameExit = false;
            }
        } while (checkNameExit);

        System.out.println("Trạng thái: ");
        Status = sc.nextBoolean();
    }

    @Override
    public void displayData() {
        String statusText = Status ? "Còn hàng" : "Hết hàng";
        System.out.printf("Mã danh mục: %d -  Danh mục: %s - Trạng thái: %s  \n", this.catalogId, this.catalogName, statusText);
    }

}
