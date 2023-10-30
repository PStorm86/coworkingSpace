package ch.zli.m223.init;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.repository.RoleRepository;
import ch.zli.m223.roles.UserRoles;
import ch.zli.m223.service.ticketing.ticketingService;
import ch.zli.m223.service.user.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServerInitialisation implements ApplicationRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final ticketingService ticketingService;

    @Value("${test.data.create.user:false}")
    private boolean createTestDataForUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (createTestDataForUser) {
            roleRepository.addRole(UserRoles.member);
            roleRepository.addRole(UserRoles.admin);
            
            var user1 = userService.addUser("admin", "admin", "admin@admin.com", "admin");
            var user2 = userService.addUser("Max", "Werner", "max@werner.com", "maxwerner");
            var user3 = userService.addUser("Mini", "Max", "mini@max.com", "minimax");
            var user4 = userService.addUser("Lady", "Gaga", "lady@gaga.com", "ladygaga");


            ticketingService.addTicket(user1, LocalDate.now(), true, true, StatusImpl.New);
            ticketingService.addTicket(user1, LocalDate.now(), false, true, StatusImpl.Booked);
            ticketingService.addTicket(user2, LocalDate.now(), true, false, StatusImpl.New);
            ticketingService.addTicket(user4, LocalDate.now(), true, true, StatusImpl.Rejected);
            ticketingService.addTicket(user3, LocalDate.now(), true, false, StatusImpl.New);
            ticketingService.addTicket(user3, LocalDate.now(), true, false, StatusImpl.New);
            ticketingService.addTicket(user2, LocalDate.now(), false, true, StatusImpl.Booked);
            ticketingService.addTicket(user2, LocalDate.now(), true, true, StatusImpl.New);

        }
    }
    
}
