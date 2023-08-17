package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop<Product> {

    private String producId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    public Product() {
    }


    public Product(String producId, String productName, float price, String title, int catalogId, boolean status) {
        this.producId = producId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProducId() {
        return producId;
    }

    public void setProducId(String producId) {
        this.producId = producId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc, List<Product> listProduct) {
        System.out.println("Nhập vào mã sản phẩm: ");
        boolean checkProductId = true;
        do {
            String producId = sc.nextLine();
            boolean checkId = false;
            for (Product proId :
                    listProduct) {
                if (proId.producId.equalsIgnoreCase(producId)) {
                    checkId = true;
                    break;
                }
            }
            if (checkId) {
                System.err.println("Mã sản phẩm đã bị trùng lặp, vui lòng nhập lại");
            } else {
//                this.producId = producId;
                if (producId.length() == 5 && producId.charAt(0) == 'P') {
                    this.producId = producId;
                    break;
                } else {
                    System.err.println("Mã sản phẩm gồm 5 ký tự, và bắt đầu bằng chữ 'P', vui lòng nhập lại.");
                }
            }


        } while (checkProductId);

        //tên
        System.out.println("Nhập tên sản phẩm:");
        boolean checkNameExit = true;

        do {
            boolean checkCatalogNameExit = false;
            String productName = sc.nextLine();
            for (Product element :
                    listProduct) {
                if (element.getProductName().equalsIgnoreCase(productName)) {
                    checkCatalogNameExit = true;
                    break;
                }
            }
            if (checkCatalogNameExit) {
                System.err.println("Tên sản phẩm đã tồn tại");
            } else {
                this.productName = productName;
                checkNameExit = false;

            }
        } while (checkNameExit);

        boolean checkPrice;
        do {
            checkPrice = true;
            System.out.println("Giá sản phẩm: ");
            this.price = Float.parseFloat(sc.nextLine());
            if (this.price>0) {
                checkPrice = false;
                break;
            }

        } while (checkPrice);

        System.out.println("Tiêu đề: ");
        this.title = sc.nextLine();

        System.out.println("trạng thái: ");
        this.status = Boolean.parseBoolean(sc.nextLine());

    }
    public void newListCategories(Scanner sc,List<Categories> cataList) {
        System.out.println("Danh mục: ");
        for (Categories element: cataList) {
            element.displayData();
        }
        boolean isExit = true;
        do {
            this.catalogId = Integer.parseInt(sc.nextLine());
            for (Categories catalog: cataList) {
                if (catalog.getCatalogId()==this.catalogId){
                    isExit = false;
                    break;
                }
                if (isExit) {
                    System.err.println("Mã bạn vừa nhập không có, vui lòng nhập lại.");
                }
            }
        }while (isExit);
    }

    @Override
    public void displayData() {
        String status = this.status?"Còn hàng":"Hết hàng";
        System.out.printf("Ma ID: %s \t TenSp: %20s  Gia: %5.1f$ Status: %s \n", this.producId, this.productName, this.price,status  );


    }
}
