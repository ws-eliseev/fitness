package ws.eliseev.fitness.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.model.Role;
import ws.eliseev.fitness.model.User;
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

    InitRoleUser(IUserRepository iUserRepository, IRoleRepository iRoleRepository) {
        this.userRepository = iUserRepository;
        this.roleRepository = iRoleRepository;

        Role admin = checker("ROLE_ADMIN", iRoleRepository);
        Role user = checker("ROLE_USER", iRoleRepository);
        Role test = checker("ROLE_TEST", iRoleRepository);

        List<User> userList = List.of(
                new User(0L, "new_username", "password", "firstname", "lastname", "email", "phone", -10, User.Sex.MALE, Set.of(admin)),
                new User(0L, "dxhoan420", "roma", "Roman", "Konchalov", "roma@ya.ru", "8(800)555-35-35", 28, User.Sex.MALE, Set.of(user)),
                new User(0L, "ValentPr", "password", "Валентин", "lastname", "email", "+79273777777", 18, User.Sex.MALE, Set.of(admin, test, user)),
                new User(0L, "dmitryprikhunov", "passWord", "Дмитрий", "lastname", "email", "8(495)123-312-312", 18, User.Sex.MALE, Set.of(test)),
                new User(0L, "QRillich", "password111", "Кирилл", "lastname", "email", "0", -1000, User.Sex.MALE, Set.of(admin, test)),
                new User(0L, "KensynHimura", "Pa$$w0rd!#!", "Аркадий", "lastname", "email", "", 20000, User.Sex.MALE, Set.of(admin, user)),
                new User(0L, "smoke9890", "Will-molecule-manciple-rib-fiducial-alum-pierce-hierarch-coachman-squadron-canvas-commune-minstrel-poky-airspace", "Павел", "lastname", "email", "не скажу", 18, User.Sex.MALE, Set.of(admin)),
                new User(0L, "Tema41", "password41", "Артем", "lastname", "email", "123", 18, User.Sex.MALE, Set.of(user, test)),
                new User(0L, "ws-eliseev", "password☺/☻/–", "Александр", "lastname", "email", "345476", 1, User.Sex.MALE, null),
                new User(0L, "YaSlawaMarlow", "", "Артём", "lastname", "email", "+79273777777'); DROP TABLE USERS;--", 0, User.Sex.MALE, Set.of(admin)));

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
