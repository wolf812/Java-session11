package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.*;

import static java.lang.Integer.parseInt;

public class ShopManagement {
    static List<Categories> listCategories = new ArrayList<>();
    static List<Product> listProducts = new ArrayList<>();


    public static void main(String[] args) {

        //*************************SHOP MANAGEMENT***************
        //1. Quản lý danh mục sản phẩm
        //2. Quản lý sản phẩm
        catalogtest();
        productTest();
        do {
            System.out.println("*************************SHOP MANAGEMENT***************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: \n");

            Scanner sc = new Scanner(System.in);
            int choice = parseInt(sc.nextLine());

            switch (choice) {
                case 1:
//                    System.out.println("***************** CATALOG**************");
//                    for (int i = 0; i < listCategories.size(); i++) {
//                        System.out.printf("%d.%s\n", i + 1, listCategories.get(i).getCatalogName());
//                    }
//                    System.out.println("Chọn danh mục: ");
//                    int choiceCatalog = Integer.parseInt(sc.nextLine());
                    ShopManagement.catalogMenu();
                    break;
                case 2:
                    ShopManagement.productMenu();
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 - 3");
                    break;
            }
        } while (true);

    }

    public static void catalogMenu() {

        boolean isExit;
        do {
            System.out.println("***************** CATALOG MANAGEMENT**************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)");
            System.out.println("5. Thoát (Quay lại Shop Management)");
            System.out.print("Lựa chọn của bạn: \n");

            isExit = true;
            Scanner sc = new Scanner(System.in);
            int choice = parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Categories categories = new Categories();
                    categories.inputData(sc, listCategories);
                    listCategories.add(categories);
                    System.out.println("Đã thêm");
                    break;
                case 2: // hiển thị mã danh mục
                    Iterator<Categories> categoriesIterator = listCategories.iterator();
                    while (categoriesIterator.hasNext()) {
                        Categories categories1 = categoriesIterator.next();
                        categories1.displayData();
                    }
                    break;
                case 3: // cập nhật
                    System.out.println("Nhập mã danh mục");
                    boolean catalogIdSeach = true;
                    do {
                        int catalogIdUpdate = Integer.parseInt(sc.nextLine());

                        for (Categories categories1 : listCategories
                        ) {
                            if (categories1.getCatalogId() == catalogIdUpdate) {
                                System.out.println("Nhập tên danh mục mới:");
                                String newName = sc.nextLine();
                                categories1.setCatalogName(newName);
                                System.out.println("Đã cập nhật.");
                                catalogIdSeach = false;
                            }
                        }
                        if (catalogIdSeach) {
                            System.err.println("Danh mục bạn vừa nhập không có, vui lòng nhập lại.");
                        }
                    } while (catalogIdSeach);
                    break;
                case 4:
                    System.out.println("Nhập danh mục cần xóa.");
                    boolean catalogSeachDelete = true;
                    do {
                        int catalogIdDelete = Integer.parseInt(sc.nextLine());
                        for (Categories catalogDelete : listCategories
                        ) {
                            if (catalogDelete.getCatalogId() == catalogIdDelete) {
                                catalogSeachDelete = false;
                                listCategories.remove(catalogDelete);
                                System.out.println("Đã xóa.");
                                break;
                            }
                            if (catalogSeachDelete) {
                                System.err.println("Không có danh mục bạn vừa nhập, vui lòng nhập lại.");
                            }
                        }
                    } while (catalogSeachDelete);
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 - 5");
                    break;
            }
        } while (isExit);

    }

    public static void productMenu() {
        boolean isExit;
        do {
            System.out.println(" ***************** PRODUCT MANAGEMENT**************");
            System.out.println("1. Thêm mới sản phẩm ");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
            System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("9. Thoát (Quay lại Shop Management)");
            System.out.print("Lựa chọn của bạn: \n");

            isExit = true;
            Scanner scanner = new Scanner(System.in);
            int choice = parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Product product = new Product();
                    product.inputData(scanner, listProducts);
                    product.newListCategories(scanner, listCategories);
                    listProducts.add(product);
                    System.out.println("đã thêm");
                    break;
                case 2:
                    Iterator<Product> productIterator = listProducts.iterator();
                    while (productIterator.hasNext()) {
                        Product item = productIterator.next();
                        item.displayData();
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã sản phẩm: ");
                    String productName = scanner.nextLine();
                    for (Product productPrice : listProducts
                    ) {
                        if (productPrice.getProducId().toLowerCase().equals(productName.toLowerCase())) {
                            System.out.printf("Giá cũ: %f \n", productPrice.getPrice());
                            System.out.println("Nhập giá mới: ");
                            float newPrice = Float.parseFloat(scanner.nextLine());
                            productPrice.setPrice(newPrice);
                        }
                    }
                    System.out.println("Xong");
                    break;
                case 4:
                    System.out.println("Nhập mã sản phẩm muốn xóa: ");
                    String delName = scanner.nextLine();
                    Iterator<Product> productIterator1 = listProducts.iterator();

                    while (productIterator1.hasNext()) {
                        Product product1 = productIterator1.next();
                        if (product1.getProducId().toLowerCase().contains(delName.toLowerCase())) {
                            listProducts.remove(product1);
                        } else {
                            System.out.println("Mã sản phẩm không tồn tại.");
                        }
                    }
                    break;
                case 5:
                    listProducts.sort(new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return (int) (o1.getPrice() - o2.getPrice());
                        }
                    });

                    System.out.println("Sắp xếp xong.");
                    break;
                case 6:
                    listProducts.sort(new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getProductName().compareTo(o2.getProductName());
                        }

                    });
                    System.out.println("Sắp xếp xong.");

                    break;
                case 7:
                    for (Categories cate : listCategories) {
                        int cnt = 0;
                        for (Product pro : listProducts) {
                            if (pro.getCatalogId() == cate.getCatalogId()) {
                                cnt += 1;
                            }
                        }
                        System.out.printf("%s : %d \n", cate.getCatalogName(), cnt);
                    }
                    break;
                case 8:
                    System.out.println("Tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    Iterator<Product> productSeach = listProducts.iterator();
                    while (productSeach.hasNext()) // kiểm tra, nếu không có phần tử tiếp theo thì kết thúc vòng lặp
                    {
                        Product product1 = productSeach.next();
                        if (product1.getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                            product1.displayData();
                            break;
                        }
                    }
                    break;
                case 9:
                    isExit = false;
                    break;


            }
        } while (isExit);
    }

    public static void catalogtest() {
        Categories categories = new Categories(01, "Điện thoại", false);
        listCategories.add(categories);
        categories = new Categories(02, "Máy tính", true);
        listCategories.add(categories);

    }

    public static void productTest() {
        Product product = new Product("P001", "Iphone 14 promax", 500, "", 01, true);
        listProducts.add(product);
        product = new Product("P002", "Iphone 14", 300, "", 01, false);
        listProducts.add(product);
        product = new Product("P003", "Dell", 650, "", 02, true);
        listProducts.add(product);
        product = new Product("P004", "Lenovo", 550, "", 02, false);
        listProducts.add(product);
        product = new Product("P005", "MSI", 600, "", 02, true);
        listProducts.add(product);


    }
}



