package ws.eliseev.fitness.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.model.Address;
import ws.eliseev.fitness.model.Passport;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IAddressRepository;
import ws.eliseev.fitness.repository.IPassportRepository;
import ws.eliseev.fitness.repository.IRoleRepository;
import ws.eliseev.fitness.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Бин для инициализации тестовых ролей и пользователей в БД
 * @author Кончалов Роман
 */

@Component
@Profile("dev")
public class InitRoleUser {

    final IUserRepository userRepository;
    final IRoleRepository roleRepository;
    final IAddressRepository addressRepository;
    final IPassportRepository passportRepository;

    InitRoleUser(IUserRepository iUserRepository, IRoleRepository iRoleRepository, IAddressRepository addressRepository, IPassportRepository passportRepository) {
        this.userRepository = iUserRepository;
        this.roleRepository = iRoleRepository;
        this.addressRepository = addressRepository;
        this.passportRepository = passportRepository;

        Role admin = checker("ROLE_ADMIN", iRoleRepository);
        Role user = checker("ROLE_USER", iRoleRepository);
        Role test = checker("ROLE_TEST", iRoleRepository);

        Address address1 = new Address(1L, "Moscow", "Moscow", "Kosmonavtov", 9, 146);
        Address address2 = new Address(2L, "Minskaya", "Minsk", "Polevaya", 23, 56);
        Address address3 = new Address(3L, "Orlovskaya", "Orel", "Pobedy", 2, 14);
        Address address4 = new Address(4L, "Tulskaya", "Tula", "Gagarina", 17, 70);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        addressList.add(address4);
        addressList.forEach(addressRepository::save);

        Passport passport1 = new Passport(1L, 234598, 2876, 23459, "valid", 376, address1);
        Passport passport2 = new Passport(2L, 768543, 4518, 32765, "valid", 253, address2);
        Passport passport3 = new Passport(3L, 128643, 2574, 20000, "non-valid", 152, address3);
        Passport passport4 = new Passport(4L, 987623, 1298, 34278, "valid", 453, address4);


        User user1 = new User(1L, "anton@mail.ru", "anton", "Anton", "Antonov", "anton@mail.ru", "+79265438765", 23, User.Sex.MALE, Set.of(admin), passport1, address1, "Photo1");
        User user2 = new User(2L, "oleg@mail.ru", "oleg", "Oleg", "Smirnov", "oleg@mail.ru", "+79262314567", 16, User.Sex.MALE, Set.of(user), passport2, address2, "Photo2");
        User user3 = new User(3L, "victor@mail.ru", "victor", "Victorov", "Victorov", "victor@mail.ru", "+79263459856", 42, User.Sex.MALE, Set.of(admin, user), passport4, address3, "Photo3");
        User user4 = new User(4L, "vera@mail.ru", "vera", "Vera", "Sibirekova", "vera@mail.ru", "+79261785643", 25, User.Sex.FEMALE, Set.of(admin, user, test), passport4, address4, "Photo3");

        List<Passport> passportList = new ArrayList<>();
        passportList.add(passport1);
        passportList.add(passport2);
        passportList.add(passport3);
        passportList.add(passport4);

        passportList.forEach(passport -> {
            passportRepository.save(passport);
        });



        List<User> userList = List.of(
                user1,
                user2,
                user3,
                user4
        );

        // Нельзя создавать пользователей с одинаковым username,
        // поэтому перед добавление тестовых данных происходит проверка,
        // что такого пользователя ещё нет
        userList.forEach(person -> {
            if (userRepository.findByUsername(person.getUsername()) == null) {
                userRepository.save(person);
            }
        });
    }

    private Role checker(String roleName, IRoleRepository roleRepository) {
        return roleRepository.findByName(roleName).orElseGet(() -> roleRepository.save(Role.builder().name(roleName).build()));
    }
}
