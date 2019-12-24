package mo.izi.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterProduct {
	private String category;
	private String designation;
	private double price;
}
