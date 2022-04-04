package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.Address;
import ws.eliseev.fitness.repository.IAddressRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressService implements IAddressService{

    private  final IAddressRepository addressRepository;

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address saveOrUpdateAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);


    }
}
