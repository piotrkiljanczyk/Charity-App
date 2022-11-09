package pl.coderslab.charity.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.interfaces.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Long giveDonationBags() {
        return donationRepository.count();
    }

    @Override
    public Long giveDonationSum() {
        return donationRepository.getDonationSum().orElse(0L);
    }
}
