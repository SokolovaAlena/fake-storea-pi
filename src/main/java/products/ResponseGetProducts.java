package products;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseGetProducts{

	@JsonProperty("ResponseGetProducts")
	private List<ResponseGetProductsItem> responseGetProducts;
}