package com.example.requestTracking;

import com.example.requestTracking.entity.Journal;
import com.example.requestTracking.entity.Request;
import com.example.requestTracking.entity.User;
import com.example.requestTracking.repository.JournalRepository;
import com.example.requestTracking.repository.RoleRepository;
import com.example.requestTracking.repository.UserRepository;
import com.example.requestTracking.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class RequestsApplicationTests {
	@Mock
	UserService userService;
	@Mock
	UserRepository userRepository;
	@Mock
	RoleRepository roleRepository;
	@Mock
	PasswordEncoder passwordEncoder;
	@Mock
	JournalRepository journalRepository;
	@Test
	void contextLoads() {
		User user = new User(10,"test","test","test","test2", "test2",
				roleRepository.findByRoleName("Администратор"));
		userService.addUser(user);
		assert(user.equals(userRepository.findByLoginAndPassword("test2","test2")));
	}
	@Test
	void encryptorTest(){
		System.out.println(passwordEncoder.encode("test"));
	}
	@Test
	void addJournalTest(){
		Journal journal = new Journal();
		journal.setName("testName");
		journalRepository.save(journal);
		assert (journal.equals(journalRepository.findById(journal.getJournalId()).orElse(null)));
	}
//	@Test
//	void addRequestTest(){
//		Request request = new Request();
//		request.setServiceName("testName");
//		requestRepository.save(request);
//		assert (requestRepository.findByName(request.getServiceName()));
//	}
	@Test
	void replaceRoleTest(){
		User user = userRepository.findByLoginAndPassword("test", "test");
		user.setRole(roleRepository.findByRoleName("Администратор"));
		assert (userRepository.findByLoginAndPassword("test","test").equals(user));
	}

}
