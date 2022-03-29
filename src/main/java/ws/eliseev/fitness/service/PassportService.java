package ws.eliseev.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.model.Passport;
import ws.eliseev.fitness.repository.IPassportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassportService implements IPassportService {


    private final IPassportRepository passportRepository;

    @Autowired
    public PassportService(IPassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<Passport> getAllPassport() {
        return passportRepository.findAll();
    }

    @Override
    public Passport saveOrUpdatePassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Optional<Passport> getPassportById(Long id) {
        return passportRepository.findById(id);
    }

    @Override
    public void deletePassportById(Long id) {
        passportRepository.deleteById(id);

    }
}
