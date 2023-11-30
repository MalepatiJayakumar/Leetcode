package in.ineuron.config;

import org.springframework.dao.DuplicateKeyException;

public class Tet {
	
	public static void main(String[] args) {
		throw new DuplicateKeyException("");
	}
	
}