package in.ineuron.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nitin This class holds Model data
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer customerId;

	private String customerName;

	private String customerEmail;

}
