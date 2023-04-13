package io.geextudio.coffeelab.domains;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity//("TblCoffee")
@ApiModel("咖啡领域对象")
public class Coffee {
    @Id
    @ApiModelProperty("咖啡的Id")
    private String id;

    @ApiModelProperty("咖啡名称")
    private  String name;

    @ApiModelProperty("咖啡的描述信息")
    private String description;

    public Coffee () {

    }

    public Coffee (String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Coffee (String name, String description) {
        this(UUID.randomUUID().toString(), name, description);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}