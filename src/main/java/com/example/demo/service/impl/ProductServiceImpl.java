@Service
public class ProductServiceImpl {

    public String getModel(Product product) {
        return product.getModelNumber();
    }
}
