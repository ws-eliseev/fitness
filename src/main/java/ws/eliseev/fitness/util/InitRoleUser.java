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
//                new User(0L, "dmitryprikhunov", "passWord", "Дмитрий", "lastname", "email", "8(495)123-312-312", 18, User.Sex.MALE, Set.of(test),passport,address,"фото1"),
//                new User(0L, "QRillich", "password111", "Кирилл", "lastname", "email", "0", -1000, User.Sex.MALE, Set.of(admin, test),passport,address,"фото1"),
//                new User(0L, "KensynHimura", "Pa$$w0rd!#!", "Аркадий", "lastname", "email", "", 20000, User.Sex.MALE, Set.of(admin, user),passport,address,"фото1"),
//                new User(0L, "smoke9890", "Will-molecule-manciple-rib-fiducial-alum-pierce-hierarch-coachman-squadron-canvas-commune-minstrel-poky-airspace", "Павел", "lastname", "email", "не скажу", 18, User.Sex.MALE, Set.of(admin),passport,address,"фото1"),
//                new User(0L, "Tema41", "password41", "Артем", "lastname", "email", "123", 18, User.Sex.MALE, Set.of(user, test),passport,address,"фото1"),
//                new User(0L, "ws-eliseev", "password☺/☻/–", "Александр", "lastname", "email", "345476", 1, User.Sex.MALE, null,passport,address,"фото1"),
//                new User(0L, "YaSlawaMarlow", "", "Артём", "lastname", "email", "+79273777777'); DROP TABLE USERS;--", 0, User.Sex.MALE, Set.of(admin) ,passport,address,"фото1"));

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
