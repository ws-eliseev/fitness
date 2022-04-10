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

/**
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

        Address address1 = new Address(1L, "Moscow", "Moscow", "Zelenyi pr.", 24, 150);
        Address address2 = new Address(2L, "Tverskaya", "Tver", "Krasnaya,", 5, 15);
        Address address3 = new Address(3L, "Minskaya", "Minsk", "Parkovaya", 34, 50);
        Address address4 = new Address(4L, "Omskaya", "Omsk", "Vesennyaya", 21, 1);
        Address address5 = new Address(5L, "Tulskaya", "Tula", "Oruzheynikov", 2, 5);
        Address address6 = new Address(6L, "Orovskaya", "Orel", "Krutaya", 8, 65);
        Address address7 = new Address(7L, "Yaroslavskaya", "Rybinsk", "Beregovaya", 54, 70);
        Address address8 = new Address(8L, "Voronezhskaya", "Voronezh", "Letnyaya", 23, 3);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        addressList.add(address4);
        addressList.add(address5);
        addressList.add(address6);
        addressList.add(address7);
        addressList.add(address8);

        addressList.forEach(address -> {
            addressRepository.save(address);
        });

        Passport passport1 = new Passport(1L, 345677, 4532, 45657, "valid", 245, address1);
        Passport passport2= new Passport(2L, 543789, 4567, 234567, "valid", 321, address2);
        Passport passport3= new Passport(3L, 453876, 5467, 120348, "non-valid", 453, address3);
        Passport passport4= new Passport(4L, 423893, 4523, 241187, "valid", 428, address4);
        Passport passport5= new Passport(5L, 487564, 3456, 300678, "valid", 124, address5);
        Passport passport6= new Passport(6L, 587324, 7645, 230890, "valid", 543, address6);
        Passport passport7= new Passport(7L, 423987, 5643, 020567, "valid", 987, address7);
        Passport passport8= new Passport(8L, 547895, 4518, 230789, "valid", 327, address8);

        List<Passport> passportList = new ArrayList<>();
        passportList.add(passport1);
        passportList.add(passport2);
        passportList.add(passport3);
        passportList.add(passport4);
        passportList.add(passport5);
        passportList.add(passport6);
        passportList.add(passport7);
        passportList.add(passport8);

        passportList.forEach(
                passport -> {
                    passportRepository.save(passport);
                });


        User user1 = new User(1L, "anton@mail.ru", "anton", "Anton", "Antonov", "anton@mail.ru", "+74956789023", 34, User.Sex.MALE, Set.of(admin), passport1, address1, "photo_1");
        User user2 = new User(2L, "oleg@mail.ru", "oleg", "Oleg", "Smirnov", "oleg@mail.ru", "+74953245678", 25, User.Sex.MALE, Set.of(admin, user), passport2, address2, "photo_2");
        User user3 = new User(3L, "victor@mail.ru", "victor", "Victor", "Victorov", "victor@mail.ru", "+74567324567", 18, User.Sex.MALE, Set.of(test), passport3, address3, "Photo_3");
        User user4 = new User(4L, "vera@mail.ru", "vera", "Vera", "Sibirekov", "vera@mail.ru", "+404536752345", 43, User.Sex.FEMALE, Set.of(admin), passport4, address4, "photo_4");
        User user5 = new User(5L, "valeriy@mail.ru", "valeriy", "Valeriy", "Valer'ev", "valeriy@mail.ru", "+74956785323", 12, User.Sex.MALE, Set.of(admin, user, test), passport5, address5, "photo_5");
        User user6 = new User(6L, "igor@mail.ru", "igor", "Igor", "Svetlov", "igor@mail.ru", "+74956563423", 27, User.Sex.MALE, Set.of(test), passport6, address6, "photo_6");
        User user7 = new User(7L, "alex@mail.ru", "alex", "Alex", "Makhin", "alex@mail.ru", "+74956623023", 32, User.Sex.MALE, Set.of(user), passport7, address7, "photo_7");
        User user8 = new User(8L, "sergey@mail.ru", "sergey", "Sergey", "Sergeev", "sergey@mail.ru", "+749569865423", 15, User.Sex.MALE, Set.of(admin, user, test), passport8, address8, "photo_8");


        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);


//        Address address = new Address();
//        address.setId(1L);
//        address.setCity("Москва");
//        address.setApartmentNumber(3);
//        address.setHouseNumber(2);
//        address.setRegion("Московская");
//        address.setStreet("Лубянка");
//        addressRepository.save(address);
//
//        Passport passport = new Passport();
//        passport.setId(1L);
//        passport.setAddress(address);
//        passport.setPassport_number(123554);
//        passport.setPassport_series(1223);
//        passport.setAuthority("УВД Москвы");
//        passport.setDate_of_issue(1223445);
//        passport.setSubdivision_code(1224);
//        passportRepository.save(passport);
//
//        List<User> userList = List.of(
//                new User(0L, "Ivan", "12345", "ivan", "ivanov", "ivan@email", "+777777", 10, User.Sex.MALE, Set.of(admin),passport,address,"фото1"),
//                new User(0L, "Stas", "456", "Stas", "Stasov", "stas@yundexa.ru", "+888888", 28, User.Sex.MALE, Set.of(user),passport,address,"фото2"),
//                new User(0L, "Sergey", "789", "Сергей", "Сергеев", "sergey@email", "+999999", 18, User.Sex.MALE, Set.of(admin, test, user),passport,address,"фото3"));

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
