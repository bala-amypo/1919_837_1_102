@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}
