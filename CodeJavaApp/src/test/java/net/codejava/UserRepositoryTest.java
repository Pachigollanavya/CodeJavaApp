
package net.codejava;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user=new User();
		user.setEmail("24b01a12b5@svecw.edu.in");
		user.setPassword("Navya@2006");
		user.setFirstName("Pachigolla");
		user.setLastName("Navya");
		
		User savedUser =  repo.save(user);
		
		User existUser = entityManager.find(User.class,savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		
	}
	@Test 

	public void testFindUserByEmail() {
	    User user = new User();
	    user.setEmail("24b01a12b5@svecw.edu.in");
	    user.setPassword("Navya@2006");
	    user.setFirstName("Pachigolla");
	    user.setLastName("Navya");
	    repo.save(user);

	    User fetchedUser = repo.findByEmail("24b01a12b5@svecw.edu.in");
	    assertThat(fetchedUser).isNotNull();
	}
	
}