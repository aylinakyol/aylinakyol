package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();
    Result add(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
    DataResult<List<Product>>getByProductNameOrCategory(String productName, int categoryId);
    DataResult<List<Product>>getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>>getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product> >getByNameAndAndCategory(String productName,int categoryId);

}
