package hw05.task1.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author YevhenKovalevskyi
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="shops")
public class Shop implements Serializable {

    @Serial
    private static final long serialVersionUID = -3760445487636086036L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_id", columnDefinition = "INT UNSIGNED")
    private Integer id;
    
    @Column(name="s_name", columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;
    
    @Column(name="s_city", columnDefinition = "VARCHAR(50) NOT NULL")
    private String city;
    
    @Column(name="s_address", columnDefinition = "VARCHAR(100) NOT NULL")
    private String address;
    
    @Column(name="s_has_site", columnDefinition = "TINYINT UNSIGNED NOT NULL DEFAULT '0'")
    private Integer hasSite;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private String createdAt;
    
    @Column(name="updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'")
    private String updatedAt;
    
    @OneToMany(targetEntity=Employee.class, mappedBy="shop", cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Employee> employees;
    
    public static Shop build(Map<String, String> params) {
        return Shop.builder()
                .name(params.get("name"))
                .city(params.get("city"))
                .address(params.get("address"))
                .hasSite(Integer.parseInt(params.get("hasSite")))
                .createdAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .updatedAt("0000-00-00 00:00:00")
                .build();
    }
    
    public static Shop build(Map<String, String> params, Integer id) {
        return Shop.builder()
                .id(id)
                .name(params.get("name"))
                .city(params.get("city"))
                .address(params.get("address"))
                .hasSite(Integer.parseInt(params.get("hasSite")))
                .updatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .build();
    }
    
    public static Shop build(Shop params) {
        return Shop.builder()
                .name(params.getName())
                .city(params.getCity())
                .address(params.getAddress())
                .hasSite(params.getHasSite())
                .createdAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .updatedAt("0000-00-00 00:00:00")
                .build();
    }
    
    public static Shop build(Shop params, Integer id) {
        return Shop.builder()
                .id(id)
                .name(params.getName())
                .city(params.getCity())
                .address(params.getAddress())
                .hasSite(params.getHasSite())
                .createdAt(params.getCreatedAt())
                .updatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .build();
    }
}
