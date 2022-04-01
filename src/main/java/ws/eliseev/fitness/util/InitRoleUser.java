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
    final IPassportRepository passportRepository;
    final IAddressRepository addressRepository;

    InitRoleUser(IUserRepository iUserRepository, IRoleRepository iRoleRepository, IPassportRepository passportRepository, IAddressRepository addressRepository) {
        this.userRepository = iUserRepository;
        this.roleRepository = iRoleRepository;
        this.passportRepository = passportRepository;
        this.addressRepository = addressRepository;

        Role admin = checker("ROLE_ADMIN", iRoleRepository);
        Role user = checker("ROLE_USER", iRoleRepository);
        Role test = checker("ROLE_TEST", iRoleRepository);

        Address address = new Address();
        address.setId(1L);
        address.setCity("Москва");
        address.setApartmentNumber(3);
        address.setHouseNumber(2);
        address.setRegion("Московская область");
        address.setStreet("Лубянка");
        addressRepository.save(address);

        Passport passport = new Passport();
        passport.setId(1L);
        passport.setAddress(address);
        passport.setPassport_number(123554);
        passport.setPassport_series(1223);
        passport.setAuthority("УВД Москвы");
        passport.setDate_of_issue(1223445);
        passport.setSubdivision_code(1224);
        passportRepository.save(passport);

        List<User> userList = List.of(
                new User(0L, "Ivan", "12345", "ivan", "ivanov", "ivan@email", "+777777", 10, User.Sex.MALE, Set.of(admin),passport,address,"фото1"),
                new User(0L, "Stas", "456", "Stas", "Stasov", "stas@yundexa.ru", "+888888", 28, User.Sex.MALE, Set.of(user),passport,address,"фото2"),
                new User(0L, "Sergey", "789", "Сергей", "Сергеев", "sergey@email", "+999999", 18, User.Sex.MALE, Set.of(admin, test, user),passport,address,"фото3"));

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
