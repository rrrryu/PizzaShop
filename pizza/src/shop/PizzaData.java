package shop;
import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PizzaData {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String name;
     
    @Persistent
    private String address;
     
    @Persistent
    private String tell;
    
    @Persistent
    private String pizza;
    
     
    @Persistent
    private Date datetime;
 
    public PizzaData(String name, String address, String tell, String pizza, Date datetime) {
        super();
        this.name = name;
        this.address = address;
        this.tell = tell;
        this.pizza = pizza;
        this.datetime = datetime;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getTell() {
        return tell;
    }
 
    public void setTell(String tell) {
        this.tell = tell;
    }
    
    public String getPizza() {
        return pizza;
    }
 
    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
    
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

}
