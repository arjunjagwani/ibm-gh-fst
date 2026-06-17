import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

	
	@Test
	public void notEnoughFunds() {
		BankAccount bankAccount=new BankAccount(10);
		assertThrows(NotEnoughFundsException.class, ()->bankAccount.withdraw(20));
	}
	@Test
	public void enoughFunds() {
		BankAccount bankAccount=new BankAccount(100);
		assertDoesNotThrow(()->bankAccount.withdraw(60));
	}
}
