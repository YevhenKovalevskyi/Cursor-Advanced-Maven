package hw06.task1.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author YevhenKovalevskyi
 */
@Data
public class ProductDto {
    
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer manufactured;
    private Integer useBefore;
    private CountryProductDto country;
}
